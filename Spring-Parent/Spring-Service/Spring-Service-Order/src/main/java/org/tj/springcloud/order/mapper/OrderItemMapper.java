package org.tj.springcloud.order.mapper;

import org.tj.springcloud.common.model.orderservice.OrderItem;

import java.util.List;

/**
 * Created by tangjing on 2019/6/12.
 */
public interface OrderItemMapper {

    public void addNewOrderItems(List<OrderItem> orderItems);
}
