package com.shigan.service.serviceImpl.pm;

import com.shigan.mapper.PmMapper;
import com.shigan.pojo.pm.Wdzx;
import com.shigan.service.pm.WdzxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/8/1.
 */
@Service
public class WdzxServiceImpl implements WdzxService {
    @Autowired
    private PmMapper pmMapper;

    @Override
    public List<Wdzx> getwdzxbycommunityid(Integer communityid) {
        List<Wdzx> getwdzxbycommunityid = pmMapper.getwdzxbycommunityid(communityid);
        return getwdzxbycommunityid;
    }

    @Override
    public Wdzx getwdbyid(Integer id) {
        Wdzx getwdbyid = pmMapper.getwdbyid(id);
        return getwdbyid;
    }

    @Override
    public int addwdzx(Wdzx wdzx) {
        int i = pmMapper.addwdzx(wdzx);
        return i;
    }

    @Override
    public int upwd(Wdzx wdzx) {
        int i = pmMapper.upwd(wdzx);
        return i;
    }
}
