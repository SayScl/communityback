package com.shigan.controller.manager;

import com.shigan.pojo.City;
import com.shigan.pojo.User;
import com.shigan.pojo.UserRole;
import com.shigan.service.CityService;
import com.shigan.service.usermanager.UserManagerService;
import com.shigan.service.usermanager.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/6/28.
 */
@Controller
@RequestMapping("muser")
public class ManagerController {

    @Autowired
    private UserManagerService userManagerService;
   @Autowired
    private UserRoleService userRoleService;
   @Autowired
   private CityService cityService;
    @RequestMapping("usermanager")
    public String getUsers(Model model){
        List<User> users = userManagerService.getUsers();
        model.addAttribute("users",users);
        return "/manager/usermanager";
    }

    @RequestMapping("rolemanager")
    public String getUR(Model model){
        List<UserRole> list = userRoleService.getUR();
        model.addAttribute("list",list);
        return "/manager/userrole";
    }

    //查询城市与小区
    @RequestMapping("citymanager")
    public String getCity(Model model){
        List<City> list = cityService.getCity();
        model.addAttribute("citys",list);
        return "/manager/city";
    }

    //跳转到增加城市页面
    @RequestMapping("toaddcity")
    public String toaddcity(){
        return "/manager/addcity";
    }
    //跳转到增加小区页面
    @RequestMapping("toaddcommunity")
    public String toaddcommunity(){
        return "/manager/addcommunity";
    }

    //增加城市
    @RequestMapping("addcity")
    public String addcc(HttpServletRequest request){
        String cityName = request.getParameter("cityName");
        String cityid = request.getParameter("cityid");
        City city =new City();
        city.setCityName(cityName);
        city.setCityid(Integer.parseInt(cityid));
        int rows = cityService.addcity(city);
        if(rows>0){
            return "success";
        }else{
            return "faild";
        }

    }

    //查看添加的城市是否已经存在
    @GetMapping("testcity")
    @ResponseBody
    public String testcity(HttpServletRequest request){
        String cityName = request.getParameter("cityName");
        City city=new City();
        city.setCityName(cityName);
        City city1 = cityService.getone(city);
        if(city1!=null){
            return "have";
        }else{
            return "no";
        }
    }

    //查询cityid是否已经存在
    @GetMapping("testcityid")
    @ResponseBody
    public String getcityid(HttpServletRequest request){

        String cityid = request.getParameter("cityid");
        City city =new City();
        if(cityid!=null){
            city.setCityid(Integer.parseInt(cityid));
        }
        City c1 = cityService.getcityid(city);
        if(c1!=null){
            return "have";
        }else{
            return "no";
        }
    }


}
