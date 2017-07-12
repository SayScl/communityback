package com.shigan.service;

import com.shigan.pojo.Function;
import com.shigan.pojo.Mainfunction;

import java.util.List;

/**
 * Created by Administrator on 2017/6/28.
 */
public interface FunctionService {

    //根据角色ID查对应角色的功能列表
    public List<Function> getFunction(Function f);

    //查找主权限
    public List<Mainfunction> getmainfunction();
}
