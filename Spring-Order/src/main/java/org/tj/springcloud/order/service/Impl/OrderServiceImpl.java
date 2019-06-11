package org.tj.springcloud.order.service.Impl;

import org.springframework.stereotype.Service;
import org.tj.springcloud.common.model.goodservice.Goods;
import org.tj.springcloud.order.client.GoodsClient;
import org.tj.springcloud.order.service.OrderService;

import javax.annotation.Resource;
import java.util.ArrayList;
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

        Goods goods = goodsClient.findGoodInfo( goodid );
        if (goods.getStock() > 0) { //有库存
         List<Goods> goodsList =   new ArrayList<Goods>();
            goodsList.add( goods );
           // goodsClient.decreaseStock(  );
        }


        System.out.printf( "123" );
    }
}
