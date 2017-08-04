package com.shigan.service.serviceImpl.pm;

import com.shigan.mapper.PmMapper;
import com.shigan.pojo.pm.Xqgg;
import com.shigan.service.pm.XqggService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/27.
 */
@Service
public class XqggServiceImpl implements XqggService {
    @Autowired
    private PmMapper pmMapper;
    //查询小区公告
    @Override
    public List<Xqgg> getggbycommunityid(Integer communityid) {
        List<Xqgg> getggbycommunityid = pmMapper.getggbycommunityid(communityid);
        return getggbycommunityid;
    }

    @Override
    public Xqgg getgginfobyid(Integer id) {
        Xqgg getgginfobyid = pmMapper.getgginfobyid(id);
        return getgginfobyid;
    }

    //根据id修改小区公告
    @Override
    public int upgg(Xqgg xqgg) {
        int i = pmMapper.upgg(xqgg);
        return i;
    }

    //增加小区公告
    @Override
    public int addgg(Xqgg xqgg) {
        int i = pmMapper.addgg(xqgg);
        return i;
    }


}
