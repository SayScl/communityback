package com.shigan.service.usermanager;

import cn.itcast.common.page.Pagination;
import com.shigan.pojo.Ad;
import com.shigan.pojo.Adlocation;

import java.util.List;

/**
 * Created by Administrator on 2017/6/30.
 */
public interface AdManagerService {

    //查询所有广告位
    public List<Adlocation> getAdLocations();

    //查询所有广告
    public List<Ad> getAd();

    //添加一条广告
    public int addAd(Ad ad);

    //查找广告位总条数
    public int getAdLocationCount();

    //分页显示广告位
    public Pagination getAdLocationByPage(Adlocation adlocation);

    //根据Id查广告
    public Ad getAdById(Ad ad);

    //修改广告信息
    public int updateAd(Ad ad);
}
