package com.shigan.service.serviceImpl.pm;

import com.shigan.mapper.PmMapper;
import com.shigan.pojo.pm.Wyzs;
import com.shigan.service.pm.WyzsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
@Service
public class WyzsServiceImpl implements WyzsService{
    @Autowired
    private PmMapper pmMapper;
    @Override
    public int upzsbyid(Wyzs wyzs) {
        int i = pmMapper.upzsbyid(wyzs);
        return i;
    }

    @Override
    public int addzs(Wyzs wyzs) {
        int i = pmMapper.addzs(wyzs);
        return i;
    }

    @Override
    public List<Wyzs> getzsbycommunityid(Integer communityid) {
        List<Wyzs> getzsbycommunityid = pmMapper.getzsbycommunityid(communityid);
        return getzsbycommunityid;
    }

    @Override
    public Wyzs getzsbyid(Integer id) {
        Wyzs getzsbyid = pmMapper.getzsbyid(id);
        return getzsbyid;
    }
}
