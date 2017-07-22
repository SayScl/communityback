package com.shigan.mapper.supermarket;

import com.shigan.pojo.market.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/7/7.
 */
@Component
@Mapper
public interface SupermarketMapper {



     //查找超市左侧分类-->
    public List<Category> getcategory();

     // 根据名字查找分类
    public Category getcategorybyname(Category category);


    //增加分类
    public int addcategory(Category category);

    //删除分类信息（修改显示状态）
    public int delcategory(Category category);


    //修改分类信息
    public int updatecategory(Category category);





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


    //查找所有SKU
    public List<Sku> getsku();

    //添加新SKU
    public int addsku(Sku sku);


     //查找所有SKU属性-->
    public List<Skuproperty> getskuproperty();

    //<!--查找所有property-->
    public List<Property> getproperty();

    // <!--根据属性ID查找属性值-->
    public List<Property> getpropertybyid(Property property);



      //<!--查找所有商品-->
    public List<Product> getproduct();

    //<!--添加商品-->
    public int addproduct(Product product);

    //<!--删除商品-->
    public int deleteproduct(Product product);

    //查看所有商品详细信息
    public Product getproductinfo(Integer id);

      // <!--商品上架-->
    public int up(Integer id);

   // <!--商品下架-->
    public int down(Integer id);

    //!--根据所有订单-->
    public List<Order> getorder();

    //<!--开始配送-->
    public int send(Integer id);

    //<!--删除未支付订单-->
    public int deletenoplayorder(String date);

}
