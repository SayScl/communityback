package com.shigan.service.pm;

import com.shigan.pojo.pm.Kjcz;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
public interface KjczService {
    //<!--查找小区要充值的记录-->
    public List<Kjcz> getczbyuserid(Integer communityid);

    //<!--充值修改充值状态-->
    public int cz(Integer id);
}
