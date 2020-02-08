package org.tj.springcloud.goods.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tj.springcloud.common.exception.CloudException;
import org.tj.springcloud.common.model.goodservice.TbBrand;
import org.tj.springcloud.common.model.goodservice.searchpage.TbBrandPage;
import org.tj.springcloud.common.util.HttpResult;
import org.tj.springcloud.goods.service.BrandService;

import javax.annotation.Resource;

/**
 * @author tangjing
 * @desc
 * @date 2019/3/21.
 */
@RestController
@CrossOrigin
@RequestMapping("brandService")
public class BrandController {

    @Resource
    private BrandService brandService;

    /**
     * @描述
     * @参数 获取商品品牌列表
     * @返回值
     * @创建人 tangjing
     * @创建日期 2019/3/21
     * @创建时间 20:49
     */
    @RequestMapping("/brand/list")
    public HttpResult list(@RequestBody(required = false) TbBrandPage page) {
        try {
            PageInfo<TbBrand> pageInfo = brandService.findBrandListForPage(page);
            return HttpResult.OK().data(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof CloudException) {
                return HttpResult.ERROR(e.getMessage());
            }
            return HttpResult.ERROR(e.getMessage());
        }
    }


    /**
     * @描述
     * @参数 添加商品分类
     * @返回值
     * @创建人 tangjing
     * @创建日期 2019/4/3
     * @创建时间 22:33
     */
    @PostMapping("/brand")
    public HttpResult brand(@RequestBody TbBrand tbBrand) {
        //System.out.printf(tbBrand.getName() + tbBrand.getLetter());
        try {
            brandService.addNewTbrand(tbBrand);
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof CloudException) {
                return HttpResult.ERROR(e.getMessage());
            }
            return HttpResult.ERROR(e.getMessage());
        }

        return HttpResult.OK();
    }

}
