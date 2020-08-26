
package org.tj.springcloud.order.client.back;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.tj.springcloud.common.model.goodservice.Goods;
import org.tj.springcloud.common.model.goodservice.TbSku;
import org.tj.springcloud.common.model.goodservice.vo.StockVo;
import org.tj.springcloud.common.util.HttpResult;
import org.tj.springcloud.goods.api.GoodsApi;
import org.tj.springcloud.goods.api.GoodsApiAdapter;
import org.tj.springcloud.order.client.GoodsClient;

import java.util.List;


/**
 * Created by tangjing on 2019/6/4.
 */

@Slf4j
@Component
public class GoodsServiceFallback extends GoodsApiAdapter implements GoodsClient {
    @Override
    public HttpResult decreaseStock(@RequestBody StockVo stockVo) {

        log.error("调用商品扣减库存微服务失败");
        return HttpResult.ERROR();
    }

    @Override
    public Goods findGoodInfo(@PathVariable("id") String id) {
        // System.out.println( "调用查找接口失败，对其进行降级处理！" );
        return new Goods();
    }
}

