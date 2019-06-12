package org.tj.springcloud.order.service.Impl;

import org.springframework.stereotype.Service;
import org.tj.springcloud.common.exception.CloudException;
import org.tj.springcloud.common.model.goodservice.Goods;
import org.tj.springcloud.common.model.goodservice.vo.StockVo;
import org.tj.springcloud.common.util.HttpResult;
import org.tj.springcloud.order.client.GoodsClient;
import org.tj.springcloud.order.service.OrderService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by tangjing on 2019/6/3.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Resource
    private GoodsClient goodsClient;

    @Override
    public void createOrder(String goodid) {
        synchronized (this) {
            Goods goods = goodsClient.findGoodInfo( goodid );
            if (null != goods && goods.getStock() > 0) { //有库存
                StockVo vo = new StockVo( goodid, goods.getStock(), goods.getStock() - 1 );
                HttpResult result = goodsClient.decreaseStock( vo );
                if (result.isSuccess() && 1 == ((Integer) result.getData())) { //库存扣减成功
                    System.out.println( "扣减成功，还剩" + vo.getNewStock() + "个商品" );
                }
            } else {
                throw new CloudException( "无库存商品" );
            }
        }

    }
}
