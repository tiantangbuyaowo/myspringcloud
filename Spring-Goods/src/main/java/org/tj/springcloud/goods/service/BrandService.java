package org.tj.springcloud.goods.service;

import com.github.pagehelper.PageInfo;
import org.tj.springcloud.common.model.goodservice.TbBrand;
import org.tj.springcloud.common.model.goodservice.searchpage.TbBrandPage;

import java.util.List;

/**
 * @author tangjing
 * @desc
 * @date 2019/3/21.
 */
public interface BrandService {

    PageInfo<TbBrand> findBrandListForPage(TbBrandPage page);

    /**
     * @描述
     * @参数 添加商品分类
     * @返回值
     * @创建人 tangjing
     * @创建日期 2019/4/3
     * @创建时间 22:50
     */
    void addNewTbrand(TbBrand tbBrand);
}
