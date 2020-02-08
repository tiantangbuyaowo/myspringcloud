package org.tj.springcloud.goods.mapper;

import org.tj.springcloud.common.model.goodservice.Goods;
import org.tj.springcloud.common.model.goodservice.vo.StockVo;

import java.util.List;

/**
 * @author tangjing
 * @desc
 * @date 2019/5/30.
 */
public interface GoodsMapper {

    /**
     * 获取商品列表
     *
     * @param goods
     * @return
     */
    public List<Goods> findGoodsList(Goods goods);

    /**
     * 新增商品
     *
     * @param goods
     */
    void addNewGood(Goods goods);

    int decreaseStock(StockVo stockVo);

    Goods findGoodsById(String id);
}