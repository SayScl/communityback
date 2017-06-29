package com.shigan.service.usermanager;

import com.shigan.pojo.UserRole;

import java.util.List;

/**
 * Created by Administrator on 2017/6/28.
 */
public interface UserRoleService {

    //插入权限表
    public int add(UserRole ur);

    //删除权限
    public int delete(UserRole ur);

    //查询所有角色对应的功能
    public List<UserRole> getUR();
}
