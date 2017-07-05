package com.shigan.mapper.manager;

import cn.itcast.common.page.Pagination;
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

    //查询所有广告
    public List<Ad> getAd();

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

      //查找广告位总条数
    public int getAdLocationCount();

    //分页显示广告位
    public List<Adlocation> getAdLocationByPage(Adlocation adlocation);

     //根据Id查广告
    public Ad getAdById(Ad ad);

     //修改广告信息
    public int updateAd(Ad ad);
}
