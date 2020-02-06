package org.tj.springcloud.order.mapper;

import org.tj.springcloud.common.model.orderservice.Order;

/**
 * Created by tangjing on 2019/6/12.
 */
public interface OrderMapper {

    public void addNewOrder(Order order);
}
