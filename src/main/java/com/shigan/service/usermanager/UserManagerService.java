package com.shigan.service.usermanager;

import com.shigan.pojo.User;

import java.util.List;

/**
 * Created by Administrator on 2017/6/28.
 */
public interface UserManagerService {

    //查询所有用户
    public List<User> getUsers();

    //查询一个用户
    public User getUser(User user);
}
