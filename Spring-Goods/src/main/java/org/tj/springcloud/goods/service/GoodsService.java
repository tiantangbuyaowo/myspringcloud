package org.tj.springcloud.goods.service;

import org.tj.springcloud.common.model.goodservice.Goods;

/**
 * Created by tangjing on 2019/5/30.
 */
public interface GoodsService {

    public void addNewGood(Goods goods);

    void decreaseStock(Goods goods);

    Goods findGoodsById(String id);
}
