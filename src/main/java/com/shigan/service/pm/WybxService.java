package com.shigan.service.pm;

import com.shigan.pojo.pm.Wybx;

import java.util.List;

/**
 * Created by Administrator on 2017/7/28.
 */
public interface WybxService {
    //<!--查询该小区的报修情况-->
    public List<Wybx> getbxbycommunityid(Integer communityid);

    //<!--接受报修-->
    public int acceptbx(Wybx wybx);

}
