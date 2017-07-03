package com.shigan.service.serviceImpl.usermanager;

import com.shigan.mapper.manager.ManagerMapper;
import com.shigan.pojo.Limit;
import com.shigan.service.usermanager.LimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/7/3.
 */
@Service
public class LimitServiceImpl implements LimitService{

    @Autowired
    private ManagerMapper managerMapper;
    @Override
    public List<Limit> getLimits() {
        List<Limit> limits = managerMapper.getLimits();
        return limits;
    }

    @Override
    @Transactional
    public int addlimit(Limit limit) {
        int i = managerMapper.addlimit(limit);
        return i;
    }

    //修改功能信息
    @Override
    public int updateLimit(Limit limit) {
        int i = managerMapper.updateLimit(limit);
        return i;
    }

    @Override
    public Limit getLimtById(Limit limit) {
        Limit limt = managerMapper.getLimtById(limit);
        return limt;
    }
}
