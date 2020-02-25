package org.tj.springcloud.goods.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tj.springcloud.common.exception.CloudException;
import org.tj.springcloud.common.model.goodservice.TbCategory;
import org.tj.springcloud.common.model.goodservice.TbCategoryTreeTableModel;
import org.tj.springcloud.common.util.HttpResult;
import org.tj.springcloud.goods.service.CategoryService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tangjing
 * @desc
 * @date 2019/3/11.
 */
@RestController
@CrossOrigin
@RequestMapping("/categoryService")
public class CategoryController {

    private class TestUser {
        public String name = "管理员";
        public String password = "admin";
        public String token = "8dfhassad0asdjwoeiruty";
        public String username = "admin";
        public String uuid = "admin-uuid";
    }

    /**
     * @描述
     * @参数 商品分类service
     * @返回值
     * @创建人 tangjing
     * @创建日期 2019/3/11
     * @创建时间 22:24
     */
    @Resource
    private CategoryService categoryService;


    
    @GetMapping("/category/list")
    public HttpResult findCategoryChildren(TbCategory tbcategory) {

        try {
            List<TbCategoryTreeTableModel> tbcs = categoryService.findCategoryTreeTable();
            return HttpResult.OK().data(tbcs);
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof CloudException) {
                return HttpResult.ERROR(e.getMessage());
            }
            return HttpResult.ERROR(e.getMessage());
        }

    }


}
