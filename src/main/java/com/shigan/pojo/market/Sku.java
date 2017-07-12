package com.shigan.pojo.market;

import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */
public class Sku {
    private Integer id;
    private Double price;
    private Integer store;
    private Integer storewarning;
    private String skupropertyid;
    private String propertyid;
    private String skuname;
    private String description;
    private List<Skuproperty> skuproperties;
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Skuproperty> getSkuproperties() {
        return skuproperties;
    }

    public void setSkuproperties(List<Skuproperty> skuproperties) {
        this.skuproperties = skuproperties;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSkuname() {
        return skuname;
    }

    public void setSkuname(String skuname) {
        this.skuname = skuname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }

    public Integer getStorewarning() {
        return storewarning;
    }

    public void setStorewarning(Integer storewarning) {
        this.storewarning = storewarning;
    }

    public String getSkupropertyid() {
        return skupropertyid;
    }

    public void setSkupropertyid(String skupropertyid) {
        this.skupropertyid = skupropertyid;
    }

    public String getPropertyid() {
        return propertyid;
    }

    public void setPropertyid(String propertyid) {
        this.propertyid = propertyid;
    }
}
