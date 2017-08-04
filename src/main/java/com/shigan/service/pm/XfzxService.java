package com.shigan.service.pm;

import com.shigan.pojo.pm.Xfzx;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/27.
 */
public interface XfzxService {

    //<!--查看该小区的装修风格-->
    public List<Xfzx> getxfzxbycommunityid(Integer communityid);


    //<!--增加装修风格-->
    public int addxfzx(Xfzx xfzx);


    //<!--根据id修改装修风格-->
    public int  upxfzxbyid(Xfzx xfzx);

    //<!--根据id查找装修风格-->
    public Xfzx getxfbyid(Integer id);
}
