package org.tj.springcloud.goods.mapper;

import org.tj.springcloud.common.model.goodservice.TbBrand;
import org.tj.springcloud.common.model.goodservice.searchpage.TbBrandPage;

import java.util.List;

/**
 * @author tangjing
 * @desc
 * @date 2019/3/21.
 */
public interface TbBrandMapper {
    /**
     * @描述
     * @参数 根据条件查询品牌列表
     * @返回值
     * @创建人 tangjing
     * @创建日期 2019/3/21
     * @创建时间 21:03
     */
    List<TbBrand> findBrandListForPage(TbBrandPage page);

    /**
     * @描述
     * @参数 添加新的商品分类
     * @返回值
     * @创建人 tangjing
     * @创建日期 2019/4/3
     * @创建时间 22:52
     */
    void addNewTbrand(TbBrand tbBrand);
}
