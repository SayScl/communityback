package com.shigan.mapper;

import com.shigan.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/6/28.
 */
@Component
@Mapper
public interface UserMapper {
    //查询所有用户
    public List<User> getUsers();

    //查询一个用户
    public User getUser(User user);

}
