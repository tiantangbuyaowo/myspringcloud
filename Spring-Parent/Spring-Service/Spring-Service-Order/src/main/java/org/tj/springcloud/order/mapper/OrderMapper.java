package org.tj.springcloud.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.tj.springcloud.common.model.orderservice.Order;

/**
 * Created by tangjing on 2019/6/12.
 */
public interface OrderMapper extends BaseMapper<Order> {

    public void addNewOrder(Order order);
}
