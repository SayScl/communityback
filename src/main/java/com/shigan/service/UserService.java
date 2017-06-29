package com.shigan.service;

import com.shigan.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/28.
 */

public interface UserService {


    //查询所有用户
    public List<User> getUsers();

    //查询一个用户
    public User getUser(User user);
}
