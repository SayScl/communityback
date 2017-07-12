package com.shigan.pojo.market;

import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */
public class Skuproperty {

    private Integer id;
    private String skupropertyname;
    private String propertyids;
    private List<Property> propertys;

    public List<Property> getPropertys() {
        return propertys;
    }

    public void setPropertys(List<Property> propertys) {
        this.propertys = propertys;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkupropertyname() {
        return skupropertyname;
    }

    public void setSkupropertyname(String skupropertyname) {
        this.skupropertyname = skupropertyname;
    }

    public String getPropertyids() {
        return propertyids;
    }

    public void setPropertyids(String propertyids) {
        this.propertyids = propertyids;
    }
}
