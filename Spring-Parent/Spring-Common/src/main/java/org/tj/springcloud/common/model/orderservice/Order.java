package org.tj.springcloud.common.model.orderservice;

import lombok.Data;
import org.tj.springcloud.common.model.base.BaseModel;

import java.util.Date;

/**
 * Created by tangjing on 2019/6/12.
 */
@Data
public class Order extends BaseModel {

    /**
     * 下单用户id
     */
    private String userid;

    /**
     * 下单时间
     */
    private Date time;


}
