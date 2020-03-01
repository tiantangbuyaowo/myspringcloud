package org.tj.springcloud.search.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 和es对应的sku
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "essku")
public class EsSku implements Serializable {

    /**
     * 商品id
     */
    @Id
    private String id;
    /**
     * 商品条码
     */
    @Field(type = FieldType.Keyword)
    private String sn;
    /**
     * SKU名称
     */
    @Field(type = FieldType.Text, analyzer = "ik_smart", searchAnalyzer = "ik_smart")
    private String name;
    /**
     * 价格（分）
     */
    @Field(type = FieldType.Integer)
    private Integer price;
    /**
     * 库存数量
     */
    @Field(type = FieldType.Integer)
    private Integer num;
    /**
     * 库存预警数量
     */
    @Field(type = FieldType.Integer)
    private Integer alertNum;
    /**
     * 商品图片
     */
    @Field(type = FieldType.Keyword)
    private String image;
    /**
     * 商品图片列表
     */
    @Field(type = FieldType.Keyword)
    private String images;
    /**
     * 重量（克）
     */
    @Field(type = FieldType.Integer)
    private Integer weight;
    /**
     * 创建时间
     */
    @Field(type = FieldType.Date)
    private Date createTime;
    /**
     * 更新时间
     */
    @Field(type = FieldType.Date)
    private Date updateTime;
    /**
     * SPUID
     */
    @Field(type = FieldType.Keyword)
    private String spuId;
    /**
     * 类目ID
     */
    @Field(type = FieldType.Keyword)
    private Integer categoryId;
    /**
     * 类目名称
     */
    @Field(type = FieldType.Keyword)
    private String categoryName;
    /**
     * 品牌名称
     */
    @Field(type = FieldType.Keyword)
    private String brandName;
    /**
     * 规格
     */
    @Field(type = FieldType.Keyword)
    private String spec;

    /**
     * 可用来生成动态域
     */

    private Map<String, String> specMap = new HashMap<>();
    /**
     * 销量
     */
    @Field(type = FieldType.Integer)
    private Integer saleNum;
    /**
     * 评论数
     */
    @Field(type = FieldType.Keyword)
    private Integer commentNum;
    /**
     * 商品状态 1-正常，2-下架，3-删除
     */
    @Field(type = FieldType.Keyword)
    private String status;


}
