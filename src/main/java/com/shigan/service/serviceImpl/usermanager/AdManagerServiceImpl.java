package com.shigan.service.serviceImpl.usermanager;

import cn.itcast.common.page.Pagination;
import com.shigan.mapper.manager.ManagerMapper;
import com.shigan.pojo.Ad;
import com.shigan.pojo.Adlocation;
import com.shigan.service.usermanager.AdManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/6/30.
 */
@Service
public class AdManagerServiceImpl implements AdManagerService{

    @Autowired
    private ManagerMapper managerMapper;
    //查询所有广告位
    @Override
    public List<Adlocation> getAdLocations() {
        List<Adlocation> adLocations = managerMapper.getAdLocations();
        return adLocations;
    }

    //查询所有广告
    @Override
    public List<Ad> getAd() {
        List<Ad> ad = managerMapper.getAd();
        return ad;
    }

    @Override
    @Transactional
    public int addAd(Ad ad) {
        int i = managerMapper.addAd(ad);
        return i;
    }

    //查询广告位总条数
    @Override
    public int getAdLocationCount() {
        int i = managerMapper.getAdLocationCount();
        return i;
    }

    //获得广告位的分页对象
    @Override
    public Pagination getAdLocationByPage(Adlocation adlocation) {
        int total = managerMapper.getAdLocationCount();
        Pagination pagination=new Pagination(adlocation.getStartrow(),adlocation.getPageSize(),total);
        pagination.setList(managerMapper.getAdLocationByPage(adlocation));
        return pagination;
    }

    //根据Id查广告
    @Override
    public Ad getAdById(Ad ad) {
        Ad ads = managerMapper.getAdById(ad);
        return ads;
    }

    @Override
    public int updateAd(Ad ad) {
        int i = managerMapper.updateAd(ad);
        return i;
    }
}
