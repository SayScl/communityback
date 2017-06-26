package com.shigan.pojo;

/**
 * Created by Administrator on 2017/6/26.
 */
public class City {
    private Integer id;
    private String cityName;
    private Integer parentId;
    private String community;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {

        return cityName;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public Integer getId() {

        return id;
    }



    public Integer getParentId() {
        return parentId;
    }

    public String getCommunity() {
        return community;
    }
}
