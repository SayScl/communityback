package com.shigan.service.serviceImpl.usermanager;

import com.shigan.mapper.manager.UserRoleMapper;
import com.shigan.pojo.UserRole;
import com.shigan.service.usermanager.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/6/28.
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    @Transactional
    public int add(UserRole ur) {
        int rows = userRoleMapper.add(ur);
        return rows;
    }

    @Override
    @Transactional
    public int delete(UserRole ur) {
        int rows = userRoleMapper.delete(ur);
        return rows;
    }

    @Override
    public List<UserRole> getUR() {
        List<UserRole> list = userRoleMapper.getUR();
        return list;
    }
}
