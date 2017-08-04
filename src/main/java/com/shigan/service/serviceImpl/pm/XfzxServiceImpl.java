package com.shigan.service.serviceImpl.pm;

import com.shigan.mapper.PmMapper;
import com.shigan.pojo.pm.Wybx;
import com.shigan.pojo.pm.Xfzx;
import com.shigan.service.pm.XfzxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/29.
 */
@Service
public class XfzxServiceImpl implements XfzxService {
    @Autowired
    private PmMapper pmMapper;

    //查看小区装修风格列表
    @Override
    public List<Xfzx> getxfzxbycommunityid(Integer communityid) {
        List<Xfzx> getxfzxbycommunityid = pmMapper.getxfzxbycommunityid(communityid);
        return getxfzxbycommunityid;
    }

    //新增装修风格
    @Override
    public int addxfzx(Xfzx xfzx) {
        int i = pmMapper.addxfzx(xfzx);
        return i;
    }

    //修改装修风格
    @Override
    public int upxfzxbyid(Xfzx xfzx) {
        int upxfzxbyid = pmMapper.upxfzxbyid(xfzx);
        return upxfzxbyid;
    }

    //根据id查找新房
    @Override
    public Xfzx getxfbyid(Integer id) {
        Xfzx getxfbyid = pmMapper.getxfbyid(id);
        return getxfbyid;
    }
}
