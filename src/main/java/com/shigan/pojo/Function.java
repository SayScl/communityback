package com.shigan.pojo;

/**
 * Created by Administrator on 2017/6/28.
 */
public class Function {

    private Integer id;
    private String functionname;
    private String url;

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
