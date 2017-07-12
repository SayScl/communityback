package com.shigan.service.serviceImpl.supermarket;

import com.shigan.mapper.supermarket.SupermarketMapper;
import com.shigan.pojo.market.Skuproperty;
import com.shigan.service.supermarket.SkupropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */
@Service
public class SkupropertyServiceImpl implements SkupropertyService {

    @Autowired
    private SupermarketMapper supermarketMapper;
    @Override
    public List<Skuproperty> getskuproperty() {
        List<Skuproperty> skuproperties = supermarketMapper.getskuproperty();
        return skuproperties;
    }
}
