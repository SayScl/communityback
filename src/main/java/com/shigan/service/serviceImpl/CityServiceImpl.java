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
}
