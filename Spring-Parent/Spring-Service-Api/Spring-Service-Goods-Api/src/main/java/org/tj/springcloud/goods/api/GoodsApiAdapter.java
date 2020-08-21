package org.tj.springcloud.goods.api;

import org.tj.springcloud.common.model.goodservice.Goods;
import org.tj.springcloud.common.model.goodservice.TbSku;
import org.tj.springcloud.common.model.goodservice.vo.StockVo;
import org.tj.springcloud.common.util.HttpResult;

import java.util.List;

public abstract class GoodsApiAdapter implements GoodsApi {

    @Override
    public HttpResult decreaseStock(StockVo stockVo) {
        return null;
    }

    @Override
    public Goods findGoodInfo(String id) {
        return null;
    }

    @Override
    public HttpResult<List<TbSku>> skuList() {
        return null;
    }
}
