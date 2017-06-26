package com.shigan.service.serviceImpl;

import com.shigan.mapper.CityMapper;
import com.shigan.pojo.City;
import com.shigan.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
