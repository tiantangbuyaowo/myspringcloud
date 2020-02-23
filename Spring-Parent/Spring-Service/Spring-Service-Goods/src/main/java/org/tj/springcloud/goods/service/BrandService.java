package org.tj.springcloud.goods.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.tj.springcloud.common.model.goodservice.TbBrand;
import org.tj.springcloud.common.model.goodservice.searchpage.TbBrandPage;

/**
 * @author tangjing
 * @desc
 * @date 2019/3/21.
 */
public interface BrandService {

    Page<TbBrand> findBrandListForPage(TbBrandPage page);

    /**
     * @描述
     * @参数 添加商品分类
     * @返回值
     * @创建人 tangjing
     * @创建日期 2019/4/3
     * @创建时间 22:50
     */
    void addNewTbrand(TbBrand tbBrand);

    /**
     * 根据id查询数据
     *
     * @param id
     * @return
     */
    TbBrand findBrandById(String id);
}
