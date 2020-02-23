package org.tj.springcloud.common.model.goodservice.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Builder
public class AddGoodsVo {

    /**
     * 标题
     */
    @NotNull(message = "商品标题不能为空")
    private String title;

    /**
     * 描述
     */

    //@Pattern(regexp = "^[A-Za-z0-9]+$", message = "商品描述不能为空")
    @NotNull(message = "商品描述不能为空")
    private String goodsDesc;

    /**
     * 库存
     */
    @Pattern(regexp = "^\\+?[1-9][0-9]*$", message = "商品库存必须为正整数,最小为0")
    //@Min(value = 0, message = "商品库存必须为正整数,最小为0")
    private String stock;

}
