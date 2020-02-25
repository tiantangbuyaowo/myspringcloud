package org.tj.springcloud.goods.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.tj.springcloud.common.model.common.TreeModel;
import org.tj.springcloud.common.model.goodservice.TbCategory;
import org.tj.springcloud.common.model.goodservice.TbCategoryTreeTableModel;
import org.tj.springcloud.goods.mapper.CategoryMapper;
import org.tj.springcloud.goods.service.CategoryService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tangjing
 * @desc
 * @date 2019/3/11.
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    /**
     * @描述
     * @参数 商品类目操作mapper
     * @返回值
     * @创建人 tangjing
     * @创建日期 2019/3/11
     * @创建时间 22:13
     */
    @Resource
    private CategoryMapper gategoryMapper;

    @Override
    //@Cacheable("tbTree")
    public List<TbCategoryTreeTableModel> findCategoryTreeTable() {
        return gategoryMapper.findCategoryTreeTable();
    }
}
