package com.shigan.service;

import com.shigan.pojo.City;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/26.
 */
public interface CityService {

   // 查询城市列表
    public List<City> getCity();
}
