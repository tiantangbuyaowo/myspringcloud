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
import org.tj.springcloud.common.model.goodservice.TbSku;
import org.tj.springcloud.common.model.goodservice.vo.AddGoodsVo;
import org.tj.springcloud.common.model.goodservice.vo.StockVo;
import org.tj.springcloud.common.util.HttpResult;
import org.tj.springcloud.goods.service.BrandService;
import org.tj.springcloud.goods.service.GoodsService;
import org.tj.springcloud.goods.service.SkuService;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author tangjing
 * @desc
 * @date 2019/3/11.
 */
@RestController
@CrossOrigin
@RequestMapping("/skuService")
public class SkuController {

    @Resource
    private SkuService skuService;

    /**
     * @描述
     * @参数 获取sku列表
     * @返回值
     * @创建人 tangjing
     * @创建日期 2019/3/21
     * @创建时间 20:49
     */
    @GetMapping("/sku/list")
    public HttpResult<TbSku> skuList() {
        return HttpResult.OK().data(skuService.findAllSku());

    }


}
