package com.shigan.service.supermarket;

import com.shigan.pojo.market.Product;

import java.util.List;

/**
 * Created by Administrator on 2017/7/12.
 */
public interface ProductService {

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

    //<!--修改商品信息-->
    public int updateproduct(Product product);
}
