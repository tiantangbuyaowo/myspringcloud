package org.tj.springcloud.common.model.goodservice.vo;

import lombok.Data;

/**
 * 处理库存的服务对象
 * Created by tangjing on 2019/6/11.
 */
@Data
public class StockVo {

    /**
     * 商品id
     */
    private String id;

    /**
     * 旧库存
     */
    private Integer oldStock;

    /**
     * 新库存
     */
    private Integer newStock;

    public StockVo() {
    }

    public StockVo(String id, Integer oldStock, Integer newStock) {
        this.id = id;
        this.oldStock = oldStock;
        this.newStock = newStock;
    }
}
