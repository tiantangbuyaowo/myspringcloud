package org.tj.springcloud.goods.mapper;

import org.tj.springcloud.common.model.common.TreeModel;
import org.tj.springcloud.common.model.goodservice.TbCategory;
import org.tj.springcloud.common.model.goodservice.TbCategoryTreeTableModel;

import java.util.List;

/**
 * @author tangjing
 * @desc
 * @date 2019/3/11.
 */
public interface CategoryMapper {

    /**
     * @描述
     * @参数 根据pid查询其下的子分类
     * @返回值
     * @创建人 tangjing
     * @创建日期 2019/3/11
     * @创建时间 22:20
     */
    List<TbCategoryTreeTableModel> findCategoryTreeTable();
}
