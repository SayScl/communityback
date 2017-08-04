package com.shigan.service.supermarket;

import com.shigan.pojo.market.Order;

import java.util.List;

/**
 * Created by Administrator on 2017/7/21.
 */
public interface OrderService {

    //!--根据所有订单-->
    public List<Order> getorder();

    //<!--开始配送-->
    public int send(Integer id);

    //<!--删除未支付订单-->
    public int deletenoplayorder(String date);

    //<!--退钱-->
    public int reback(Integer id);
}
