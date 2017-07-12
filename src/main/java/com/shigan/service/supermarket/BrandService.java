package com.shigan.service.supermarket;

import com.shigan.pojo.market.Brand;

import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */
public interface BrandService {

    //查找品牌分类-->
    public List<Brand> getbrand();


    // 根据名字查找品牌
    public Brand getbrandbyname(Brand brand);


    //增加品牌
    public int addbrand(Brand brand);

    //删除品牌信息（修改显示状态）
    public int delbrand(Brand brand);


    //修改品牌信息
    public int updatebrand(Brand brand);
}
