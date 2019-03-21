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
}
