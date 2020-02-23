package org.tj.springcloud.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.tj.springcloud.common.model.orderservice.OrderItem;

import java.util.List;

/**
 * Created by tangjing on 2019/6/12.
 */
public interface OrderItemMapper extends BaseMapper<OrderItem> {

    public void addNewOrderItems(List<OrderItem> orderItems);
}
