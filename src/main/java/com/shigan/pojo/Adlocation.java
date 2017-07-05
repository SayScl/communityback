package com.shigan.pojo;

/**
 * Created by Administrator on 2017/6/30.
 */
public class Adlocation {

    private Integer id;
    private String location;


    private Integer pageNo=1;
    private Integer pageSize=10;
    private Integer startrow;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.startrow=(pageNo-1)*pageSize;
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.startrow=(pageNo-1)*pageSize;
        this.pageSize = pageSize;
    }

    public Integer getStartrow() {
        return startrow;
    }

    public void setStartrow(Integer startrow) {
        this.startrow = startrow;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getId() {

        return id;
    }

    public String getLocation() {
        return location;
    }
}
