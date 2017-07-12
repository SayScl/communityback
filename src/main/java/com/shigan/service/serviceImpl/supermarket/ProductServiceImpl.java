package com.shigan.service.serviceImpl.supermarket;

import com.shigan.mapper.supermarket.SupermarketMapper;
import com.shigan.pojo.market.Product;
import com.shigan.service.supermarket.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/12.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private SupermarketMapper supermarketMapper;
    @Override
    public List<Product> getproduct() {
        List<Product> products = supermarketMapper.getproduct();
        return products;
    }

    @Override
    public int addproduct(Product product) {
        int i = supermarketMapper.addproduct(product);
        return i;
    }

    @Override
    public int deleteproduct(Product product) {
        int i = supermarketMapper.deleteproduct(product);
        return i;
    }

    //查看所有商品详细信息
    @Override
    public Product getproductinfo(Integer id) {
        Product info = supermarketMapper.getproductinfo(id);
        return info;
    }


    // <!--商品上架-->
    public int up(Integer id){
        int i = supermarketMapper.up(id);
        return i;

    }

    // <!--商品下架-->
    public int down(Integer id){
        int i = supermarketMapper.down(id);
        return i;
    }
}
