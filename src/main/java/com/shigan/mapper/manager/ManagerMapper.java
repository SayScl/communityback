package com.shigan.mapper.manager;

import com.shigan.pojo.Ad;
import com.shigan.pojo.Adlocation;
import com.shigan.pojo.Limit;
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

    //查询所有页面功能
    public List<Limit> getLimits();


    //添加页面功能
    public int addlimit(Limit limit);


    //修改功能信息
    public int updateLimit(Limit limit);


      //根据id查找页面功能
    public Limit getLimtById(Limit limit);
}
