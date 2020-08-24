package org.tj.springcloud.goods.service.impl;

import org.springframework.stereotype.Service;
import org.tj.springcloud.common.model.goodservice.TbSku;
import org.tj.springcloud.goods.mapper.SkuMapper;
import org.tj.springcloud.goods.service.SkuService;

import javax.annotation.Resource;
import java.util.List;

@Service("skuService")
public class SkuServiceImpl implements SkuService {


    @Resource
    private SkuMapper skuMapper;

    @Override
    public List<TbSku> findAllSku() {
        return skuMapper.selectList(null);
    }
}
