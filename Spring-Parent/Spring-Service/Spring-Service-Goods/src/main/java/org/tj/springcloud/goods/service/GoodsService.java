package org.tj.springcloud.goods.service;

import org.tj.springcloud.common.model.goodservice.Goods;
import org.tj.springcloud.common.model.goodservice.vo.AddGoodsVo;
import org.tj.springcloud.common.model.goodservice.vo.StockVo;

/**
 * Created by tangjing on 2019/5/30.
 */
public interface GoodsService {

    public void addNewGood(AddGoodsVo goods);

    int decreaseStock(StockVo stockVo);

    Goods findGoodsById(String id);
}
