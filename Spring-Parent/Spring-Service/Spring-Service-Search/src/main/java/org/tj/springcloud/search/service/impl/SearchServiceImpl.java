package org.tj.springcloud.search.service.impl;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.tj.springcloud.common.model.goodservice.TbSku;
import org.tj.springcloud.common.util.HttpResult;
import org.tj.springcloud.search.client.GoodsClient;
import org.tj.springcloud.search.mapper.SkuEsMapper;
import org.tj.springcloud.search.model.pojo.EsSku;
import org.tj.springcloud.search.service.SearchService;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

@Service("searchService")
public class SearchServiceImpl implements SearchService {


    @Resource
    private GoodsClient goodsClient;

    @Resource
    private SkuEsMapper skuEsMapper;

    @Resource
    private RestHighLevelClient elasticsearchClient;


    @Override
    @Async
    public void initSkuInfo() {
        HttpResult<List<TbSku>> result = goodsClient.skuList();

        if (result.success() && null != result.getData() && result.getData().size() > 0) {
            /*List<TbSku> data = result.getData().subList(0, 1);
            String json = JSON.toJSONString(data);
            System.out.println(json);*/
            //有数据之后，先把数据转换成es对象
            List<EsSku> skus = JSON.parseArray(JSON.toJSONString(result.getData()), EsSku.class);

            //操作一点动态域
            for (EsSku es : skus) {
                es.setSpecMap(JSON.parseObject(es.getSpec(), Map.class));
            }

            //执行插入操作
            skuEsMapper.saveAll(skus);
            System.out.println("插入完成");

        }


    }

    /**
     * 去es查询数据
     *
     * @param searchMap
     */
    @Override
    public Map<String, Object> searchSkuInfo(Map<String, String> searchMap) throws IOException {


        /**
         * 返回结果封装map
         */
        Map<String, Object> resultMap = new HashMap<>();


        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        SearchRequest rq = new SearchRequest();
        //索引
        rq.indices("essku");

        //处理查询体
        buildQueryBody(searchMap, sourceBuilder);

        //处理聚合体
        buildAggBody(sourceBuilder);


        //条件设置
        rq.source(sourceBuilder);


        /**
         * 发起请求
         */
        SearchResponse rp = elasticsearchClient.search(rq, RequestOptions.DEFAULT);

        /**
         * 解析主返回体，将数据设置给data
         */
        parseDataBody(resultMap, sourceBuilder, rp);


        //前台传了品牌，就不用聚合品牌
        if (null != searchMap && StringUtils.isEmpty(searchMap.get("brand"))) {
            //品牌聚合处理
            paresAggBody("brandList", "by_brandName", rp, resultMap);
        }


        //分类聚合处理
        paresAggBody("categoryList", "by_categoryName", rp, resultMap);

        //属性聚合处理
        paresAggSpecBody("specList", "by_spec", rp, resultMap);
        //paresAggBody("specList", "by_spec", rp, resultMap);

        return resultMap;


    }

    private void paresAggBody(String mapKey, String aggKey, SearchResponse rp, Map<String, Object> resultMap) {
        List<String> brandList = new ArrayList<>();
        Terms byBrandNameAggregation = rp.getAggregations().get(aggKey);
        for (Terms.Bucket buck : byBrandNameAggregation.getBuckets()) {
            brandList.add(buck.getKeyAsString());

        }
        resultMap.put(mapKey, brandList);
    }

    /**
     * 要把json数据做个处理，然后丢回去
     *
     * @param mapKey
     * @param aggKey
     * @param rp
     * @param resultMap
     */
    private void paresAggSpecBody(String mapKey, String aggKey, SearchResponse rp, Map<String, Object> resultMap) {

        Map<String, TreeSet<String>> specMap = new HashMap<String, TreeSet<String>>();
        Terms byBrandNameAggregation = rp.getAggregations().get(aggKey);
        for (Terms.Bucket buck : byBrandNameAggregation.getBuckets()) {
            Map<String, String> map = JSON.parseObject(buck.getKeyAsString(), Map.class);
            for (String key : map.keySet()) {
                if (specMap.containsKey(key)) {
                    specMap.get(key).add(map.get(key));
                } else {
                    TreeSet<String> set = new TreeSet<>();
                    set.add(map.get(key));
                    specMap.put(key, set);
                }
            }

        }
        resultMap.put(mapKey, specMap);
    }

    private void parseDataBody(Map<String, Object> resultMap, SearchSourceBuilder sourceBuilder, SearchResponse rp) {
        List<TbSku> TsList = new ArrayList<>();

        SearchHits hits = rp.getHits();
        //总数
        long totalHits = hits.getTotalHits();
        //总分
        float maxScore = hits.getMaxScore();


        for (SearchHit hit : hits) {
            TbSku tbsku = JSON.parseObject(hit.getSourceAsString(), TbSku.class);
            //Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            HighlightField highlight = highlightFields.get("name");
            if (null != highlight) {
                Text[] titleTexts = highlight.getFragments();
                StringBuilder name = new StringBuilder("");
                for (Text text : titleTexts) {
                    name.append(text);
                }
                tbsku.setName(name.toString());

            }
            TsList.add(tbsku);

        }

        resultMap.put("data", TsList);
        resultMap.put("total", totalHits);
        resultMap.put("page", sourceBuilder.from());
        resultMap.put("pageSize", sourceBuilder.size());
    }

    private void buildAggBody(SearchSourceBuilder sourceBuilder) {
        //分类聚合查询
        TermsAggregationBuilder categoryAggregation = AggregationBuilders.terms("by_categoryName")
                .field("categoryName").size(10000);
        sourceBuilder.aggregation(categoryAggregation);

        //分类聚合查询
        TermsAggregationBuilder brandNameAggregation = AggregationBuilders.terms("by_brandName")
                .field("brandName").size(10000);
        sourceBuilder.aggregation(brandNameAggregation);

        //属性聚合查询
        TermsAggregationBuilder specAggregation = AggregationBuilders.terms("by_spec")
                .field("spec").size(10000);
        sourceBuilder.aggregation(specAggregation);
    }

    private void buildQueryBody(Map<String, String> searchMap, SearchSourceBuilder sourceBuilder) {

        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();

        //商品名称检索
        if (null != searchMap && !StringUtils.isEmpty(searchMap.get("keyword"))) {
            boolQueryBuilder.must(QueryBuilders.matchQuery("name", searchMap.remove("keyword")));
            //构建高亮体
            HighlightBuilder highlightBuilder = new HighlightBuilder();
            highlightBuilder.preTags("<span style=\"color:red\">");
            highlightBuilder.postTags("</span>");
            //高亮字段
            highlightBuilder.field("name");
            //搜索体（添加多个搜索参数）
            sourceBuilder.highlighter(highlightBuilder);


        }

        //品牌过滤
        if (null != searchMap && !StringUtils.isEmpty(searchMap.get("brand"))) {
            boolQueryBuilder.must(QueryBuilders.termsQuery("brandName", searchMap.remove("brand").split(",")));
        }


        //属性过滤，属性设置为 spec_ 开头的
        if (null != searchMap) {
            for (String key : searchMap.keySet()) {
                if (key.startsWith("spec_")) { //这就认为是属性查询的
                    boolQueryBuilder.must(QueryBuilders.termQuery("specMap." + key.substring(5, key.length()) + ".keyword", searchMap.get(key)));
                }
            }

        }


        //价格最低过滤
        if (null != searchMap &&
                !StringUtils.isEmpty(searchMap.get("minPrice")) &&
                StringUtils.isNumeric(searchMap.get("minPrice"))) {

            boolQueryBuilder.must(QueryBuilders.rangeQuery("price").gte(Integer.valueOf(searchMap.get("minPrice"))));


        }


        //价格最高过滤
        if (null != searchMap &&
                !StringUtils.isEmpty(searchMap.get("maxPrice")) &&
                StringUtils.isNumeric(searchMap.get("maxPrice"))) {

            boolQueryBuilder.must(QueryBuilders.rangeQuery("price").lte(Integer.valueOf(searchMap.get("maxPrice"))));


        }


        sourceBuilder.query(boolQueryBuilder);

        if (null != searchMap && !StringUtils.isEmpty(searchMap.get("orderKey"))) {
            sourceBuilder.sort(searchMap.get("orderKey"), SortOrder.DESC.toString().equalsIgnoreCase(searchMap.get("orderType")) ? SortOrder.DESC : SortOrder.ASC);
        }


        if (null != searchMap && !StringUtils.isEmpty(searchMap.get("page")) && StringUtils.isNumeric(searchMap.get("page"))) {
            sourceBuilder.from(Integer.valueOf(searchMap.get("page")));
        } else {
            sourceBuilder.from(0);
        }
        if (null != searchMap && !StringUtils.isEmpty(searchMap.get("pageSize")) && StringUtils.isNumeric(searchMap.get("pageSize"))) {
            sourceBuilder.size(Integer.valueOf(searchMap.get("pageSize")));
        } else {
            sourceBuilder.size(10);
        }
    }
}
