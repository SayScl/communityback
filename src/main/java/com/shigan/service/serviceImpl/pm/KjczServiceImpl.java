package com.shigan.service.serviceImpl.pm;

import com.shigan.mapper.PmMapper;
import com.shigan.pojo.pm.Kjcz;
import com.shigan.service.pm.KjczService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
@Service
public class KjczServiceImpl implements KjczService {
    @Autowired
    private PmMapper pmMapper;
    //查找小区要充值的人
    @Override
    public List<Kjcz> getczbyuserid(Integer communityid) {
        List<Kjcz> getczbyuserid = pmMapper.getczbyuserid(communityid);
        return getczbyuserid;
    }

    //充值
    @Override
    public int cz(Integer id) {
        int i = pmMapper.cz(id);
        return i;
    }
}
