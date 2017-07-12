package com.shigan.service.supermarket;

import com.shigan.pojo.market.Brand;
import com.shigan.pojo.market.Category;

import java.util.List;

/**
 * Created by Administrator on 2017/7/7.
 */
public interface CategoryService {

    //查找超市左侧分类-->
    public List<com.shigan.pojo.market.Category> getcategory();


    // 根据名字查找分类
    public Category getcategorybyname(Category category);


    //增加分类
    public int addcategory(Category category);

    //删除分类信息（修改显示状态）
    public int delcategory(Category category);


    //修改分类信息
    public int updatecategory(Category category);


}
