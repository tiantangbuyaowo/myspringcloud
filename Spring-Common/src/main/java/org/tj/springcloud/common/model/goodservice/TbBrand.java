package org.tj.springcloud.common.model.goodservice;

import lombok.Data;
import org.tj.springcloud.common.model.base.BaseModel;

/**
 * @author tangjing
 * @desc
 * @date 2019/3/21.
 */
@Data
public class TbBrand extends BaseModel {
    /**
     * 品牌名称
     */
    private String name;
    /**
     * 品牌图片地址
     */
    private String image;
    /**
     * 品牌的首字母
     */
    private String letter;
}
