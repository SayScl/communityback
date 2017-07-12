package com.shigan.service.serviceImpl.supermarket;

import com.shigan.mapper.supermarket.SupermarketMapper;
import com.shigan.pojo.market.Property;
import com.shigan.service.supermarket.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/11.
 */
@Service
public class PropertyServiceImpl implements PropertyService{
    @Autowired
    private SupermarketMapper supermarketMapper;
    @Override
    public List<Property> getproperty() {
        return null;
    }

    @Override
    public List<Property> getpropertybyid(Property property) {
        List<Property> properties = supermarketMapper.getpropertybyid(property);
        return properties;
    }
}
