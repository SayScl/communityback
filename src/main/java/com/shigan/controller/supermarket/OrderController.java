package com.shigan.controller.supermarket;

import com.shigan.pojo.market.Order;
import com.shigan.pojo.market.Shopcaritems;
import com.shigan.service.supermarket.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/7/21.
 */
@Controller
@RequestMapping("market")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //查看是否有新订单
    @RequestMapping("order")
    @ResponseBody
    public String getorder() throws ParseException {
        List<Order> getorder = orderService.getorder();
        boolean flag=false;
        for(Order o:getorder){
            Integer playstatu = o.getPlaystatu();
            Integer sendstatu = o.getSendstatu();
            if(playstatu==1 && sendstatu==2){
                flag=true;
            }else if(playstatu==0) {
                Calendar canow=Calendar.getInstance();
                int daynow = canow.get(Calendar.DAY_OF_MONTH);
                int monthnow = canow.get(Calendar.MONTH);
                String createtime = o.getCreatetime();
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date parse = sdf.parse(createtime);
                Calendar ca=Calendar.getInstance();
                ca.setTime(parse);
                int createday = ca.get(Calendar.DAY_OF_MONTH);
                int createmonth = ca.get(Calendar.MONTH);
                if(monthnow>createmonth){
                    orderService.deletenoplayorder(createtime);
                }else if(daynow>createday){
                    orderService.deletenoplayorder(createtime);
                }
            }
        }
        if(flag){
            return "have";
        }else{
            return "no";
        }
    }

    //跳转到订单页
    @RequestMapping("toorder")
    public String toorder(Model model){
        List<Order> shoporders = orderService.getorder();
        for(int i=0;i<shoporders.size();i++){
            String shoplist = shoporders.get(i).getShoplist();
            String[] s1 = shoplist.split(":");
            List<Shopcaritems> list=new ArrayList<Shopcaritems>();
            for(int j=0;j<s1.length;j++){
                Shopcaritems sp=new Shopcaritems();
                String[] s2 = s1[j].split(",");
                sp.setProductname(s2[0]);
                sp.setProducttotalprice(Double.parseDouble(s2[1]));
                sp.setProductcount(Integer.parseInt(s2[2]));
                list.add(sp);
            }
            shoporders.get(i).setShopcaritems(list);
        }
        model.addAttribute("shoporder",shoporders);
        return "/supermarket/order";
    }

    @RequestMapping("send")
    @ResponseBody
    public String send(HttpServletRequest request){
        String id = request.getParameter("id");
        int i = orderService.send(Integer.parseInt(id));
        if(i>0){
            return "success";
        }else{
            return "faild";
        }
    }
}
