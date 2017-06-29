package com.shigan.service;

import com.shigan.pojo.City;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/26.
 */
public interface CityService {

    // 查询所有城市所有小区
    public List<City> getCity();
    //增加城市
    public int addcity(City city);
    //增加小区
    public int addcommunity(City city);


    //查询一个城市或小区信息
    public City getone(City city);


    //查询城市id是否有
    public City getcityid(City city);
}
