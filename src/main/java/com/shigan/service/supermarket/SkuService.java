package com.shigan.service.supermarket;

import com.shigan.pojo.market.Sku;

import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */
public interface SkuService {

    //查找所有SKU
    public List<Sku> getsku();

    //添加新SKU
    public int addsku(Sku sku);
}
