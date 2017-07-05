package com.shigan.service.usermanager;

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
}
