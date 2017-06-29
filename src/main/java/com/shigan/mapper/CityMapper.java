package com.shigan.mapper;

import com.shigan.pojo.City;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/6/26.
 */
@Component
@Mapper
public interface CityMapper {
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
