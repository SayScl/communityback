package com.shigan.pojo.market;

import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */
public class Property {
    private Integer id;
    private String propertyname;
    private List ids;

    public List getIds() {
        return ids;
    }

    public void setIds(List ids) {
        this.ids = ids;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPropertyname() {
        return propertyname;
    }

    public void setPropertyname(String propertyname) {
        this.propertyname = propertyname;
    }
}
