package com.shigan.service.pm;

import com.shigan.pojo.pm.Se;
import com.shigan.pojo.pm.Xqtp;

import java.util.List;

/**
 * Created by Administrator on 2017/8/1.
 */
public interface XqtpService {
    //<!--查看该小区的投票-->
    public List<Xqtp> gettpbycommunityid(Integer communityid);

    //<!--增加新的投票-->
    public int addtp(Xqtp xqtp);

    //<!--根据id查找投票-->
    public Xqtp gettpbyid(Integer id);

    // <!--修改投票信息-->
    public int uptp(Xqtp xqtp);


    //<!--增加选项-->
    public int addse(List<Se> se);

    //<!--投票保存后查找这个投票id-->
    public int getid(Xqtp xqtp);

    //<!--根据tid查选项-->
    public List<Se> getsebyftid(Integer tid);
}
