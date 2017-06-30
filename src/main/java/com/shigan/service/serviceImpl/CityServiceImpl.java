package com.shigan.service.serviceImpl;

import com.shigan.mapper.CityMapper;
import com.shigan.pojo.City;
import com.shigan.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/6/26.
 */
@Service
public class CityServiceImpl implements CityService {
    
    @Autowired
    private CityMapper cityMapper;
    @Override
    public List<City> getCity() {
        List<City> list = cityMapper.getCity();
        return list;
    }

    //添加城市
    @Override
    @Transactional
    public int addcity(City city) {
        int addcity = cityMapper.addcity(city);
        return addcity;
    }

    @Override
    @Transactional
    public int addcommunity(City city) {
        int addcommunity = cityMapper.addcommunity(city);
        return addcommunity;
    }

    @Override
    public City getone(City city) {
        City city1 = cityMapper.getone(city);
        return city1;
    }

    @Override
    public City getcityid(City city) {
        City c1 = cityMapper.getcityid(city);
        return c1;
    }

    //查询所有城市名
    @Override
    public List<City> getcityname() {
        List<City> list = cityMapper.getcityname();
        return list;
    }

    //查找这个城市下是否已经有小区名了
    public City getCommunity(City city){
        City community = cityMapper.getCommunity(city);
        return community;
    }



    //根据cityid查城市信息
    public List<City> getCityByCityId(City city){
        List<City> cityByCityId = cityMapper.getCityByCityId(city);
        return cityByCityId;
    }

    //增加小区1
    public int addcommunity1(City city){
        int i = cityMapper.addcommunity1(city);
        return i;
    }
}
