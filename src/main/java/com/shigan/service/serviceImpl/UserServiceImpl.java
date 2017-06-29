package com.shigan.service.serviceImpl;

import com.shigan.mapper.UserMapper;
import com.shigan.pojo.User;
import com.shigan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/28.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User getUser(User user) {
        User u1 = userMapper.getUser(user);
        return u1;
    }
}
