package com.shigan.pojo.market;

/**
 * Created by Administrator on 2017/7/7.
 */
public class Category {
    private Integer id;
    private String categoryname;
    private Integer isshow;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public Integer getIsshow() {
        return isshow;
    }

    public void setIsshow(Integer isshow) {
        this.isshow = isshow;
    }
}
