package org.tj.springcloud.search.service;

import java.io.IOException;
import java.util.Map;

public interface SearchService {
    /**
     * 初始化sku数据
     */
    void initSkuInfo();

    /**
     * 查询数据
     *
     * @param searchMap
     */
    Map<String, Object> searchSkuInfo(Map<String, String> searchMap) throws IOException;
}
