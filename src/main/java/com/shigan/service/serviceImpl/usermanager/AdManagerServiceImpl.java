package com.shigan.service.serviceImpl.usermanager;

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

    @Override
    @Transactional
    public int addAd(Ad ad) {
        int i = managerMapper.addAd(ad);
        return i;
    }
}
