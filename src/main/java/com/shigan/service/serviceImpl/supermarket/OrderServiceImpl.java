package com.shigan.service.serviceImpl.supermarket;

import com.shigan.mapper.supermarket.SupermarketMapper;
import com.shigan.pojo.market.Order;
import com.shigan.service.supermarket.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/21.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private SupermarketMapper supermarketMapper;
    //查询所有订单
    @Override
    public List<Order> getorder() {
        List<Order> getorder = supermarketMapper.getorder();
        return getorder;
    }

    //开始配送
    @Override
    public int send(Integer id) {
        int i = supermarketMapper.send(id);
        return i;
    }

    @Override
    public int deletenoplayorder(String date) {
        int i = supermarketMapper.deletenoplayorder(date);
        return i;
    }


}
