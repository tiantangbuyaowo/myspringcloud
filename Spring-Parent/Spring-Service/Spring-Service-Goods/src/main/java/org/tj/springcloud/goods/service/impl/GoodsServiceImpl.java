package org.tj.springcloud.goods.service.impl;

//import com.codingapi.txlcn.tc.annotation.DTXPropagation;
//import com.codingapi.txlcn.tc.annotation.LcnTransaction;
//import com.codingapi.txlcn.tc.annotation.TxcTransaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tj.springcloud.common.model.goodservice.Goods;
import org.tj.springcloud.common.model.goodservice.vo.AddGoodsVo;
import org.tj.springcloud.common.model.goodservice.vo.StockVo;
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
    public void addNewGood(AddGoodsVo goods) {
        // goods.setId(idWorker.nextId() + "");
        Goods gd = //null;//new Goods();
                Goods.builder().goodsDesc(goods.getGoodsDesc()).title(goods.getTitle()).stock(Integer.valueOf(goods.getStock())).build();
        gd.setId(idWorker.nextId() + "");
        /*gd.setGoodsDesc(goods.getGoodsDesc());
        gd.setStock(Integer.valueOf(goods.getStock()));
        gd.setTitle(goods.getTitle());*/
        goodsMapper.insert(gd);
        goodsMapper.deleteById(gd.getId());
    }

    //@TxcTransaction(propagation = DTXPropagation.SUPPORTS)
    //@LcnTransaction //分布式事务注解
    @Transactional  //本地事务注解
    @Override
    public int decreaseStock(StockVo stockVo) {
        return goodsMapper.decreaseStock(stockVo);
    }

    @Override
    public Goods findGoodsById(String id) {
        return goodsMapper.selectById(id);
    }
}
