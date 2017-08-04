package com.shigan.service.serviceImpl.supermarket;

import com.shigan.mapper.supermarket.SupermarketMapper;
import com.shigan.pojo.market.Brand;
import com.shigan.service.supermarket.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private SupermarketMapper supermarketMapper;

    @Override
    public List<Brand> getbrand() {
        List<Brand> brands = supermarketMapper.getbrand();
        return brands;
    }

    @Override
    public Brand getbrandbyname(Brand brand) {
        return null;
    }

    @Override
    public int addbrand(Brand brand) {
        int i = supermarketMapper.addbrand(brand);
        return i;
    }

    @Override
    public int delbrand(Brand brand) {
        return 0;
    }

    @Override
    public int updatebrand(Brand brand) {
        return 0;
    }
}
