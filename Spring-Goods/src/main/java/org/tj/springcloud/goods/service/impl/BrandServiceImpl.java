package org.tj.springcloud.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.tj.springcloud.common.model.goodservice.TbBrand;
import org.tj.springcloud.common.model.goodservice.searchpage.TbBrandPage;
import org.tj.springcloud.goods.mapper.TbBrandMapper;
import org.tj.springcloud.goods.service.BrandService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tangjing
 * @desc
 * @date 2019/3/21.
 */
@Service("brandService")
public class BrandServiceImpl implements BrandService {


    /**
     * @描述
     * @参数 品牌管理mapper
     * @返回值
     * @创建人 tangjing
     * @创建日期 2019/3/21
     * @创建时间 21:03
     */
    @Resource
    private TbBrandMapper tbBrandMapper;

    @Override
    public PageInfo<TbBrand> findBrandListForPage(TbBrandPage page) {

        PageHelper.startPage(page.getPageCurrent(), page.getPageSize());

        List<TbBrand> list = tbBrandMapper.findBrandListForPage(page);
        PageInfo<TbBrand> pageInfo = new PageInfo<TbBrand>(list);
        return pageInfo;
    }
}
