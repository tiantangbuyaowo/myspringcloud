package org.tj.springcloud.goods.service.impl;

import org.tj.springcloud.common.model.goodservice.Goods;
import org.tj.springcloud.goods.mapper.GoodsMapper;
import org.tj.springcloud.goods.service.GoodsService;

import javax.annotation.Resource;

/**
 * Created by tangjing on 2019/5/30.
 */
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public void addNewGood(Goods goods) {
        goodsMapper.addNewGood(goods);
    }
}
