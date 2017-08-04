package com.shigan.service.pm;

import com.shigan.pojo.pm.Wyzs;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
public interface WyzsService {
    //<!--修改小区物业展示内容-->
    public int  upzsbyid(Wyzs wyzs);

    //<!--增加小区物业工作展示-->
    public int addzs(Wyzs wyzs);
    //<!--小区物业展示-->
    public List<Wyzs> getzsbycommunityid(Integer communityid);

    //<!--根据id查物业工作展示-->
    public Wyzs getzsbyid(Integer id);

}
