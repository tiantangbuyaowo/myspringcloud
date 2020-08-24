package org.tj.springcloud.goods.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.tj.springcloud.common.model.goodservice.TbBrand;
import org.tj.springcloud.common.model.goodservice.TbSku;
import org.tj.springcloud.common.model.goodservice.searchpage.TbBrandPage;

import java.util.List;

/**
 * @author tangjing
 * @desc
 * @date 2019/3/21.
 */
public interface SkuService {

    public List<TbSku> findAllSku();

}
