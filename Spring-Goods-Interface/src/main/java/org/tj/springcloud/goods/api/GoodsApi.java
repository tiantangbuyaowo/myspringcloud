package org.tj.springcloud.goods.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.tj.springcloud.common.model.goodservice.Goods;

import java.util.List;

/**
 * Created by tangjing on 2019/6/3.
 */
public interface GoodsApi {


    /**
     * 减库存
     *
     * @param goodsList
     */
    @PostMapping("stock/decrease")
    void decreaseStock(@RequestBody List<Goods> goodsList);
}
