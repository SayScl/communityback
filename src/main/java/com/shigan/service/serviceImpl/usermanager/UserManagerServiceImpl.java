package com.shigan.service.serviceImpl.usermanager;

import com.shigan.mapper.UserMapper;
import com.shigan.pojo.User;
import com.shigan.service.usermanager.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/28.
 */
@Service
public class UserManagerServiceImpl implements UserManagerService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUsers() {
        List<User> users = userMapper.getUsers();
        return users;
    }

    @Override
    public User getUser(User user) {
        return null;
    }
}
