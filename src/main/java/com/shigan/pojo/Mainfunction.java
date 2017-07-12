package com.shigan.pojo;

import java.util.List;

/**
 * Created by Administrator on 2017/7/7.
 */
public class Mainfunction {

        private Integer id;
        private String mainfunctionname;
        private List<Function> functions;

    public List<Function> getFunctions() {
        return functions;
    }

    public void setFunctions(List<Function> functions) {
        this.functions = functions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMainfunctionname() {
        return mainfunctionname;
    }

    public void setMainfunctionname(String mainfunctionname) {
        this.mainfunctionname = mainfunctionname;
    }
}
