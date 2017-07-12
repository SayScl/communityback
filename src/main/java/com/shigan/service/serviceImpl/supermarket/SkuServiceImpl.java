package com.shigan.service.serviceImpl.supermarket;

import com.shigan.mapper.supermarket.SupermarketMapper;
import com.shigan.pojo.market.Sku;
import com.shigan.service.supermarket.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */
@Service
public class SkuServiceImpl implements SkuService{

    @Autowired
    private SupermarketMapper supermarketMapper;
    @Override
    public List<Sku> getsku() {
        List<Sku> skus = supermarketMapper.getsku();
        return skus;
    }

    @Override
    @Transactional
    public int addsku(Sku sku) {
        int i = supermarketMapper.addsku(sku);
        return i;
    }
}
