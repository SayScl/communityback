package com.shigan.controller.manager;

import com.shigan.mapper.manager.ManagerMapper;
import com.shigan.pojo.*;
import com.shigan.service.CityService;
import com.shigan.service.QiniuUploadService;
import com.shigan.service.usermanager.AdManagerService;
import com.shigan.service.usermanager.UserManagerService;
import com.shigan.service.usermanager.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    private AdManagerService adManagerService;

    @Autowired
    private UserManagerService userManagerService;
   @Autowired
    private UserRoleService userRoleService;
   @Autowired
   private CityService cityService;
   @Autowired
   private QiniuUploadService qiniuUploadService;
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
    public String toaddcommunity(Model model){
        List<City> list = cityService.getcityname();
        model.addAttribute("citys",list);
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

    //查找小区是否已经存在
    @GetMapping("testcommunity")
    @ResponseBody
    public String testcommunity(HttpServletRequest request){
        String community = request.getParameter("community");
        String cityid = request.getParameter("cityid");
        City city=new City();
        city.setCommunity(community);
        if(cityid!=null){
            city.setCityid(Integer.parseInt(cityid));
        }
        City community1 = cityService.getCommunity(city);
        if(community1!=null){
            return "have";
        }else{
            return "no";
        }
    }


    //增加小区
    @GetMapping("addcommunity")
    @ResponseBody
    public String addcommunity(HttpServletRequest request){
        String community = request.getParameter("community");
        String cityid = request.getParameter("cityid");
        City c1=new City();
        c1.setCommunity(community);
        if(cityid!=null){
            c1.setCityid(Integer.parseInt(cityid));
            c1.setParentId(Integer.parseInt(cityid));
        }
        List<City> cityByCityId = cityService.getCityByCityId(c1);
        for(int i=0;i<cityByCityId.size();i++){
            if(cityByCityId.get(i).getParentId()==null && cityByCityId.get(i).getCommunity()==null){
                c1.setId(cityByCityId.get(i).getId());
                int row = cityService.addcommunity(c1);
                if(row>0){
                    return "success";
                }else{
                    return "faild";
                }
            }
        }
        c1.setCityName(cityByCityId.get(0).getCityName());
        int rows = cityService.addcommunity1(c1);
        if(rows>0){
            return "success";
        }else{
            return "faild";
        }
    }

    //获得七牛的token
    @GetMapping("/token")
    @ResponseBody
    public String getUploadToken() {
        String token = this.qiniuUploadService.getUploadToken();
        return token;
    }



    //跳转到广告管理页面
    @RequestMapping("toadmanager")
    public String toAdManager(Model model){
        List<Adlocation> adLocations = adManagerService.getAdLocations();
        model.addAttribute("list",adLocations);
        return "/manager/upload";
    }


    //添加一条广告
    @PostMapping("addAd")
    @ResponseBody
    public String addAd(HttpServletRequest request){
        Ad ad=new Ad();
        String adname = request.getParameter("adname");
        String adlocationid = request.getParameter("adlocationid");
        if(adlocationid!=null){
            ad.setAdlocationid(Integer.parseInt(adlocationid));
        }
        String url = request.getParameter("url");
        String path = request.getParameter("path");
        ad.setAdname(adname);
        ad.setPath(path);
        ad.setUrl(url);
        int i = adManagerService.addAd(ad);
        if(i>0){
            return "success";
        }else{
            return "faild";
        }
    }





}
