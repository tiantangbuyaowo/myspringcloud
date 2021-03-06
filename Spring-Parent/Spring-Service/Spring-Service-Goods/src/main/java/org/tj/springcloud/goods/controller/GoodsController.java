package org.tj.springcloud.goods.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tj.springcloud.common.exception.CloudException;
import org.tj.springcloud.common.model.goodservice.Goods;
import org.tj.springcloud.common.model.goodservice.vo.AddGoodsVo;
import org.tj.springcloud.common.model.goodservice.vo.StockVo;
import org.tj.springcloud.common.util.HttpResult;
import org.tj.springcloud.goods.service.BrandService;
import org.tj.springcloud.goods.service.GoodsService;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author tangjing
 * @desc
 * @date 2019/3/11.
 */
@RestController
@CrossOrigin
@RequestMapping("/goodsService")
public class GoodsController {

    /**
     * 商品数据服务
     */
    @Resource
    private GoodsService goodsService;

    @Resource
    private BrandService brandService;

    /**
     * @描述
     * @参数 获取商品列表
     * @返回值
     * @创建人 tangjing
     * @创建日期 2019/3/21
     * @创建时间 20:49
     */
    @GetMapping("/good/list")
    public HttpResult list() {
        try {
            // TimeUnit.MILLISECONDS.sleep( 3000 );
            // PageInfo<TbBrand> pageInfo = brandService.findBrandListForPage( page );
            return HttpResult.OK().data("ok");
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof CloudException) {
                return HttpResult.ERROR(e.getMessage());
            }
            return HttpResult.ERROR(e.getMessage());
        }
    }


    @PostMapping("/good")
    public HttpResult addNewGood(
            @Valid @RequestBody AddGoodsVo addGoodsVo) {
        try {
            goodsService.addNewGood(addGoodsVo);
            return HttpResult.OK();
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof CloudException) {
                return HttpResult.ERROR(e.getMessage());
            }
            return HttpResult.ERROR(e.getMessage());
        }
    }


    @GetMapping("/good/{id}")
    public Goods findGoodInfo(@PathVariable("id") String id) {
        return goodsService.findGoodsById(id);

    }


    @PostMapping("/good/stock/decrease")
    public HttpResult reduceStock(@RequestBody StockVo stockVo) {
        try {
            int count = goodsService.decreaseStock(stockVo);
            return HttpResult.OK().data(count);
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof CloudException) {
                return HttpResult.ERROR(e.getMessage());
            }
            return HttpResult.ERROR(e.getMessage());
        }

    }


}
