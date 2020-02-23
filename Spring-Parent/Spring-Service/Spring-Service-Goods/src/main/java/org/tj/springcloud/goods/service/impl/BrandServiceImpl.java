package org.tj.springcloud.goods.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.tj.springcloud.common.model.goodservice.TbBrand;
import org.tj.springcloud.common.model.goodservice.searchpage.TbBrandPage;
import org.tj.springcloud.common.util.IdWorker;
import org.tj.springcloud.goods.mapper.TbBrandMapper;
import org.tj.springcloud.goods.service.BrandService;

import javax.annotation.Resource;

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


    @Resource
    private IdWorker idWorker;


    @Override
    public Page<TbBrand> findBrandListForPage(TbBrandPage tbpage) {
        if (null == tbpage) {
            tbpage = new TbBrandPage();
        }
        QueryWrapper<TbBrand> wrapper = new QueryWrapper();
        if (!StringUtils.isEmpty(tbpage.getName())) {
            wrapper.like("NAME", tbpage.getName());
        }

        Page<TbBrand> page = new Page<TbBrand>(tbpage.getCurrent(), tbpage.getSize());


        tbBrandMapper.selectPage(page, wrapper);

        return page;
    }


    /**
     * @描述
     * @参数 添加商品分类
     * @返回值
     * @创建人 tangjing
     * @创建日期 2019/4/3
     * @创建时间 22:50
     */
    @Override
    public void addNewTbrand(TbBrand tbBrand) {
        /*tbBrand.setId(idWorker.nextId() + "");
        tbBrandMapper.addNewTbrand(tbBrand);*/
        tbBrand.setId(idWorker.nextId() + "");
        tbBrandMapper.insert(tbBrand);

    }


    @Override
    public TbBrand findBrandById(String id) {
        return tbBrandMapper.selectById(id);
    }
}
