package org.tj.springcloud.order.service.Impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tj.springcloud.common.exception.CloudException;
import org.tj.springcloud.common.model.goodservice.Goods;
import org.tj.springcloud.common.model.goodservice.vo.StockVo;
import org.tj.springcloud.common.model.orderservice.Order;
import org.tj.springcloud.common.model.orderservice.OrderItem;
import org.tj.springcloud.common.util.HttpResult;
import org.tj.springcloud.common.util.IdWorker;
import org.tj.springcloud.order.client.GoodsClient;
import org.tj.springcloud.order.mapper.OrderItemMapper;
import org.tj.springcloud.order.mapper.OrderMapper;
import org.tj.springcloud.order.service.OrderService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by tangjing on 2019/6/3.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Resource
    private GoodsClient goodsClient;

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderItemMapper orderItemMapper;

    @Resource
    private IdWorker idWorker;

    @LcnTransaction //分布式事务注解
    @Override
    public void createOrder(String goodid) {
        synchronized (this) {
            Goods goods = goodsClient.findGoodInfo( goodid );
            if (null != goods && null == goods.getId()) { //服务熔断
                throw new CloudException( "商品服务暂不可用" );
            } else if (null != goods && goods.getStock() > 0) { //有库存
                StockVo vo = new StockVo( goodid, goods.getStock(), goods.getStock() - 1 );
                HttpResult result = goodsClient.decreaseStock( vo );
                if (result.success() && 1 == ((Integer) result.getData())) { //库存扣减成功
                    System.out.println( "扣减成功，还剩" + vo.getNewStock() + "个商品" );
                    //生成新的订单
                    Order order = new Order();
                    order.setId( idWorker.nextId() + "" );
                    order.setUserid( "1" );
                    order.setTime( new Date() );

                    //生成订单明细
                    OrderItem item = new OrderItem();
                    item.setId( idWorker.nextId() + "" );
                    item.setGooddesc( goods.getDesc() );
                    item.setGoodtitle( goods.getTitle() );
                    item.setGoodid( goods.getId() );
                    item.setOrderid( order.getId() );
                    List<OrderItem> items = new ArrayList<>();
                    items.add( item );

                    orderItemMapper.addNewOrderItems( items );
                    int i = 1 / 0;
                    orderMapper.addNewOrder( order );


                }
            } else {
                throw new CloudException( "无库存商品" );
            }

        }
    }
}
