package org.tj.springcloud.goods.service.impl;

import org.springframework.stereotype.Service;
import org.tj.springcloud.common.model.goodservice.Goods;
import org.tj.springcloud.common.util.IdWorker;
import org.tj.springcloud.goods.mapper.GoodsMapper;
import org.tj.springcloud.goods.service.GoodsService;

import javax.annotation.Resource;

/**
 * Created by tangjing on 2019/5/30.
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;


    @Resource
    private IdWorker idWorker;

    @Override
    public void addNewGood(Goods goods) {
        goods.setId(idWorker.nextId()+"");
        goodsMapper.addNewGood(goods);
    }

    @Override
    public void decreaseStock(Goods goods) {
        goodsMapper.decreaseStock(goods);
    }

    @Override
    public Goods findGoodsById(String id) {
        return goodsMapper.findGoodsById(id);
    }
}
