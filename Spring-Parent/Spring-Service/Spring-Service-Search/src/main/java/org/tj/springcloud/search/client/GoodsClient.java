package org.tj.springcloud.search.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.tj.springcloud.goods.api.GoodsApi;


@FeignClient(value = "goods-service")
public interface GoodsClient extends GoodsApi {
}
