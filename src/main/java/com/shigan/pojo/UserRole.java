package com.shigan.pojo;

/**
 * Created by Administrator on 2017/6/28.
 */
public class UserRole {

    private Integer id;
    private Integer roleid;
    private Integer functionid;
    private String rolename;
    private String fun;

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public void setFun(String fun) {
        this.fun = fun;
    }

    public String getRolename() {

        return rolename;
    }

    public String getFun() {
        return fun;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public void setFunctionid(Integer functionid) {
        this.functionid = functionid;
    }

    public Integer getId() {
        return id;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public Integer getFunctionid() {
        return functionid;
    }
}
