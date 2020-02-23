package org.tj.springcloud.common.model.orderservice;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.tj.springcloud.common.model.base.BaseModel;

/**
 * Created by tangjing on 2019/6/12.
 */
@Getter
@Setter
@TableName("tb_order_items")
public class OrderItem extends BaseModel {

    /**
     * 对应的订单id
     */
    private String orderid;


    /**
     * 商品id
     */
    private String goodid;

    /**
     * 商品标题
     */
    private String goodtitle;

    /**
     * 商品描述
     */
    private String gooddesc;

}
