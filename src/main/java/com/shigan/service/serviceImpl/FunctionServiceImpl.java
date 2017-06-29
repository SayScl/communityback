package com.shigan.service.serviceImpl;

import com.shigan.mapper.FunctionMapper;
import com.shigan.pojo.Function;
import com.shigan.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/28.
 */
@Service
public class FunctionServiceImpl implements FunctionService{

    @Autowired
    private FunctionMapper functionMapper;
    @Override
    public List<Function> getFunction(int roleid) {
        List<Function> list = functionMapper.getFunction(roleid);
        return list;
    }
}
