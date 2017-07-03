package com.shigan.service.usermanager;

import com.shigan.pojo.Limit;

import java.util.List;

/**
 * Created by Administrator on 2017/7/3.
 */
public interface LimitService {

    //查询所有页面功能
    public List<Limit> getLimits();

    //添加页面功能
    public int addlimit(Limit limit);


    //修改功能信息
    public int updateLimit(Limit limit);

    //根据id查找页面功能
    public Limit getLimtById(Limit limit);
}
