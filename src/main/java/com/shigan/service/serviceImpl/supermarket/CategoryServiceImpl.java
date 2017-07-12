package com.shigan.service.serviceImpl.supermarket;

import com.shigan.mapper.supermarket.SupermarketMapper;
import com.shigan.pojo.market.Category;
import com.shigan.service.supermarket.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/7.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private SupermarketMapper supermarketMapper;


    @Override
    public List<Category> getcategory() {
        List<Category> getcategory = supermarketMapper.getcategory();
        return getcategory;
    }

    //根据名字查分类
    @Override
    public Category getcategorybyname(Category category) {
        Category category1 = supermarketMapper.getcategorybyname(category);
        return category1;
    }

    //增加分类
    @Override
    public int addcategory(Category category) {
        int i = supermarketMapper.addcategory(category);
        return i;
    }

    //删除分类
    @Override
    public int delcategory(Category category) {
        int i = supermarketMapper.delcategory(category);
        return i;
    }

    //修改分类信息
    @Override
    public int updatecategory(Category category) {
        int i = supermarketMapper.updatecategory(category);
        return i;
    }
}
