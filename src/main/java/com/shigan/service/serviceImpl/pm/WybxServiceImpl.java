package com.shigan.service.serviceImpl.pm;

import com.shigan.mapper.PmMapper;
import com.shigan.pojo.pm.Wybx;
import com.shigan.service.pm.WybxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/28.
 */
@Service
public class WybxServiceImpl implements WybxService {

    @Autowired
    private PmMapper pmMapper;
    //查该小区的报修情况
    @Override
    public List<Wybx> getbxbycommunityid(Integer communityid) {
        List<Wybx> getbxbycommunityid = pmMapper.getbxbycommunityid(communityid);
        return getbxbycommunityid;
    }

    //接受报修
    @Override
    public int acceptbx(Wybx wybx) {
        int i = pmMapper.acceptbx(wybx);
        return i;
    }
}
