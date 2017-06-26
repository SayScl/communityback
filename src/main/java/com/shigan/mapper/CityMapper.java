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
   // 查询城市列表
    public List<City> getCity();
}
