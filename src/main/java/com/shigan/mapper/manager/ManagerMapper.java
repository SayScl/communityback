package com.shigan.mapper.manager;

import com.shigan.pojo.Ad;
import com.shigan.pojo.Adlocation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/6/30.
 */
@Component
@Mapper
public interface ManagerMapper {

    //查询所有广告位
    public List<Adlocation> getAdLocations();

    //添加一条广告
    public int addAd(Ad ad);
}
