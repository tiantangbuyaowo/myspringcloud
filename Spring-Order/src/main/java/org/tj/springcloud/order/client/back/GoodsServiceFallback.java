package org.tj.springcloud.order.client.back;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.tj.springcloud.common.model.goodservice.Goods;
import org.tj.springcloud.goods.api.GoodsApi;
import org.tj.springcloud.order.client.GoodsClient;

import java.util.List;

/**
 * Created by tangjing on 2019/6/4.
 */
@Component
public class GoodsServiceFallback implements GoodsClient {
    @Override
    public void decreaseStock(@RequestBody List<Goods> goodsList) {
        System.out.println( "调用商品接口失败，对其进行降级处理！" );
    }
}
