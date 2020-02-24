package org.tj.springcloud.common.model.goodservice;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.tj.springcloud.common.model.base.BaseModel;

/**
 * 商品对象
 * Created by tangjing on 2019/5/30.
 */
@Getter
@Setter
@TableName(value = "tb_goods")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Goods extends BaseModel {

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String goodsDesc;

    /**
     * 库存
     */
    private Integer stock;

    //有这个字段，就会逻辑删除，否则还是物理删除
    //@TableLogic
    // private Integer flag;
}
