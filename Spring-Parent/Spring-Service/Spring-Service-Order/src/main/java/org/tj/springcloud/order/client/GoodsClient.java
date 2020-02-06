package org.tj.springcloud.order.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.tj.springcloud.goods.api.GoodsApi;
import org.tj.springcloud.order.client.back.GoodsServiceFallback;

/**
 * Created by tangjing on 2019/6/3.
 */

@FeignClient(value = "goods-service", fallback = GoodsServiceFallback.class)
//@FeignClient(value = "goods-service")
public interface GoodsClient extends GoodsApi {
}
