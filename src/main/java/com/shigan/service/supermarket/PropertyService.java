package com.shigan.service.supermarket;

import com.shigan.pojo.market.Property;

import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */
public interface PropertyService {

    //<!--查找所有property-->
    public List<Property> getproperty();

    // <!--根据属性ID查找属性值-->
    public List<Property> getpropertybyid(Property property);
}
