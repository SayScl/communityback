package com.shigan.mapper;

import com.shigan.pojo.Function;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/6/28.
 */
@Component
@Mapper
public interface FunctionMapper {

    //根据角色ID查对应角色的功能列表
    public List<Function> getFunction(int roleid);
}
