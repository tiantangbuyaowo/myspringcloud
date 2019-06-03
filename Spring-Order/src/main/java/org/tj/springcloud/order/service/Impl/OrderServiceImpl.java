package org.tj.springcloud.order.service.Impl;

import org.springframework.stereotype.Service;
import org.tj.springcloud.common.model.goodservice.Goods;
import org.tj.springcloud.order.client.GoodsClient;
import org.tj.springcloud.order.service.OrderService;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Created by tangjing on 2019/6/3.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

   // @Resource
   // private GoodsClient goodsClient;

    @Override
    public void createOrder(String goodid) {
       // goodsClient.decreaseStock( new ArrayList<Goods>() );
        System.out.printf( "123" );
    }
}
