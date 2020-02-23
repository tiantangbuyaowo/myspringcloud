package org.tj.springcloud.goods.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.tj.springcloud.common.model.goodservice.Goods;
import org.tj.springcloud.common.model.goodservice.vo.StockVo;
import org.tj.springcloud.common.util.HttpResult;

import java.util.List;

/**
 * Created by tangjing on 2019/6/3.
 */
public interface GoodsApi {


    /**
     * 减库存
     *
     * @param stockVo
     */
    @PostMapping("/goodsService/good/stock/decrease")
    HttpResult decreaseStock(@RequestBody StockVo stockVo);


    /**
     * 获取商品信息
     *
     * @param id
     */
    @GetMapping("/goodsService/good/{id}")
    Goods findGoodInfo(@PathVariable("id") String id);
}
