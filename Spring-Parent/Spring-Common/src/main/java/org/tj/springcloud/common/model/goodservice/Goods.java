package org.tj.springcloud.common.model.goodservice;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.tj.springcloud.common.model.base.BaseModel;

/**
 * 商品对象
 * Created by tangjing on 2019/5/30.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Goods extends BaseModel {

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String desc;

    /**
     * 库存
     */
    private Integer stock;
}
