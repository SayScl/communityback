package com.shigan.service.serviceImpl.pm;

import com.shigan.mapper.PmMapper;
import com.shigan.pojo.pm.Se;
import com.shigan.pojo.pm.Xqtp;
import com.shigan.service.pm.XqtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/8/1.
 */
@Service
public class XqtpServiceImpl implements XqtpService {
    @Autowired
    private PmMapper pmMapper;
    @Override
    public List<Xqtp> gettpbycommunityid(Integer communityid) {
        List<Xqtp> gettpbycommunityid = pmMapper.gettpbycommunityid(communityid);
        return gettpbycommunityid;
    }

    @Override
    public int addtp(Xqtp xqtp) {
        int i = pmMapper.addtp(xqtp);
        return i;
    }

    @Override
    public Xqtp gettpbyid(Integer id) {
        Xqtp gettpbyid = pmMapper.gettpbyid(id);
        return gettpbyid;
    }

    @Override
    public int uptp(Xqtp xqtp) {
        int i = pmMapper.uptp(xqtp);
        return i;
    }

    @Override
    public int addse(List<Se> se) {
        int i = pmMapper.addse(se);
        return i;
    }

    @Override
    public int getid(Xqtp xqtp) {
        int getid = pmMapper.getid(xqtp);
        return getid;
    }

    @Override
    public List<Se> getsebyftid(Integer tid) {
        List<Se> getsebyftid = pmMapper.getsebyftid(tid);
        return getsebyftid;
    }
}
