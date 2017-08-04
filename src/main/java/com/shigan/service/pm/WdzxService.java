package com.shigan.service.pm;

import com.shigan.pojo.pm.Wdzx;

import java.util.List;

/**
 * Created by Administrator on 2017/8/1.
 */
public interface WdzxService {

    //<!--查找该小区的个人装修日志-->
    public List<Wdzx> getwdzxbycommunityid(Integer communityid);


    //<!--根据id查找装修日志-->
    public Wdzx getwdbyid(Integer id);


    //<!--新增住户装修日志-->
    public int addwdzx(Wdzx wdzx);


    //<!--根据id修改装修日志-->
    public int upwd(Wdzx wdzx);
}
