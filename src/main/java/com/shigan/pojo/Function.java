package com.shigan.pojo;

/**
 * Created by Administrator on 2017/6/28.
 */
public class Function {

    private Integer id;
    private String functionname;
    private String url;
    private Integer mainfunctionid;
    private Integer roleid;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getMainfunctionid() {
        return mainfunctionid;
    }

    public void setMainfunctionid(Integer mainfunctionid) {
        this.mainfunctionid = mainfunctionid;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFunctionname(String functionname) {
        this.functionname = functionname;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {

        return id;
    }

    public String getFunctionname() {
        return functionname;
    }

    public String getUrl() {
        return url;
    }
}
