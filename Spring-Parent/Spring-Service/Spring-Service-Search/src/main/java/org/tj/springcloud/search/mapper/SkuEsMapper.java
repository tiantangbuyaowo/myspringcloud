package org.tj.springcloud.search.mapper;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.tj.springcloud.search.model.pojo.EsSku;

public interface SkuEsMapper extends ElasticsearchRepository<EsSku, String> {
}
