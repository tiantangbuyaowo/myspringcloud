package org.tj.springcloud.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.tj.springcloud.common.model.goodservice.Goods;
import org.tj.springcloud.common.model.goodservice.vo.StockVo;

import java.util.List;

/**
 * @author tangjing
 * @desc
 * @date 2019/5/30.
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    int decreaseStock(StockVo stockVo);

}
