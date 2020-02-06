package org.tj.springcloud.common.model.orderservice;

import lombok.Data;
import org.tj.springcloud.common.model.base.BaseModel;

/**
 * Created by tangjing on 2019/6/12.
 */
@Data
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
