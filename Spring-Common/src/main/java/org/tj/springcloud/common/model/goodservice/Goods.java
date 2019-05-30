package org.tj.springcloud.common.model.goodservice;

import lombok.Data;
import org.tj.springcloud.common.model.base.BaseModel;

/**
 * 商品对象
 * Created by tangjing on 2019/5/30.
 */
@Data
public class Goods extends BaseModel {


    private String title;

    private String desc;

}
