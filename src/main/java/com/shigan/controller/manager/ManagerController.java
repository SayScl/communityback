package com.shigan.controller.manager;

import cn.itcast.common.page.Pagination;
import cn.itcast.common.page.SimplePage;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shigan.mapper.manager.ManagerMapper;
import com.shigan.pojo.*;
import com.shigan.service.CityService;
import com.shigan.service.QiniuUploadService;
import com.shigan.service.usermanager.AdManagerService;
import com.shigan.service.usermanager.LimitService;
import com.shigan.service.usermanager.UserManagerService;
import com.shigan.service.usermanager.UserRoleService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
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
    private LimitService limitService;
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
   //用户管理
    @RequestMapping("usermanager")
    public String getUsers(Integer pageNo,Integer pageSize,Model model){
        pageNo=pageNo==null?1:pageNo;
        pageSize=pageSize==null?10:pageSize;
        //获得分页对象
        PageHelper.startPage(pageNo,pageSize);
        List<User> users = userManagerService.getUsers();
        PageInfo<User> page=new PageInfo<User>(users);
        model.addAttribute("page",page);
        return "/manager/usermanager";
    }

    //角色管理
    @RequestMapping("rolemanager")
    public String getUR(Integer pageNo,Integer pageSize,Model model){
        pageNo=pageNo==null?1:pageNo;
        pageSize=pageSize==null?10:pageSize;
        //获得分页对象
        PageHelper.startPage(pageNo,pageSize);
        List<UserRole> list = userRoleService.getUR();
        PageInfo<UserRole> page=new PageInfo<UserRole>(list);
        model.addAttribute("page",page);
        return "/manager/userrole";
    }

    //查询城市与小区
    @RequestMapping("citymanager")
    public String getCity(Integer pageNo,Integer pageSize,Model model){
        pageNo=pageNo==null?1:pageNo;
        pageSize=pageSize==null?10:pageSize;
        //获得分页对象
        PageHelper.startPage(pageNo,pageSize);
        List<City> list = cityService.getCity();
        PageInfo<City> page=new PageInfo<City>(list);
        model.addAttribute("page",page);
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
    @ResponseBody
    public String addcc(HttpServletRequest request){
        String cityName = request.getParameter("cityName");
        String cityid = request.getParameter("cityid");
        City city =new City();
        city.setCityName(cityName);
        city.setCityid(Integer.parseInt(cityid));
        city.setParentId(Integer.parseInt(cityid));
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
            if(cityByCityId.get(i).getCommunity()==null){
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
            return "have";
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
    public String toAdManager(Integer pageNo,Integer pageSize,Model model){
        pageNo=pageNo==null?1:pageNo;
        pageSize=pageSize==null?10:pageSize;
        //获得分页对象
        PageHelper.startPage(pageNo,pageSize);
        List<Ad> ads = adManagerService.getAd();
        PageInfo<Ad> page=new PageInfo<Ad>(ads);
        model.addAttribute("page",page);
        return "/manager/ad";
    }

    //跳转到新增广告业
    @RequestMapping("toupload")
    public String toupload(Model model){
        List<Adlocation> adLocations = adManagerService.getAdLocations();
        model.addAttribute("list1",adLocations);
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

    //查询所有页面功能
    @RequestMapping("limitmanager")
    public String getLimits(Integer pageNo,Integer pageSize,Model model){
        pageNo=pageNo==null?1:pageNo;
        pageSize=pageSize==null?10:pageSize;
        //获得分页对象
        PageHelper.startPage(pageNo,pageSize);
        List<Limit> limits = limitService.getLimits();
        PageInfo<Limit> page=new PageInfo<Limit>(limits);
        model.addAttribute("page",page);
        return "manager/limit";
    }

    //跳转到增加页面功能
    @RequestMapping("toAddLimit")
    public String toAddLimit(){
        return "manager/addlimit";
    }

    //增加新面面功能
    @PostMapping("addLimit")
    @ResponseBody
    public String addLimit(HttpServletRequest request){
        String limitname = request.getParameter("limitname");
        String path = request.getParameter("path");
        Limit limit=new Limit();
        limit.setLimitname(limitname);
        limit.setPath(path);
        int i = limitService.addlimit(limit);
        if(i>0){
            return "success";
        }else{
            return "faild";
        }
    }


    //跳转到修改功能信息页面
    @RequestMapping("toModifyLimit")
    public String toModifyLimit(HttpServletRequest request,Model model){
        String id = request.getParameter("id");
        Limit limit =new Limit();
        if(id!=null){
            limit.setId(Integer.parseInt(id));
        }
        Limit limt = limitService.getLimtById(limit);
        model.addAttribute("limit",limt);
        return "manager/modifyLimit";
    }


    //修改功能信息
    @PostMapping("modifyLimit")
    @ResponseBody
    public String modifyLimit(HttpServletRequest request){
        String limitname = request.getParameter("limitname");
        String path = request.getParameter("path");
        String id = request.getParameter("id");
        Limit limit=new Limit();
        if(id!=null){
            limit.setId(Integer.parseInt(id));
        }
        limit.setPath(path);
        limit.setLimitname(limitname);
        int i = limitService.updateLimit(limit);
        if(i>0) {
            return "success";
        }else{
            return "faild";
        }
    }


    //跳转到修改广告信息页面
    @RequestMapping("toModifyAd")
    public String toModifyAd(HttpServletRequest request,Model model){
        String id = request.getParameter("id");
        Ad ad=new Ad();
        if(id!=null){
            ad.setId(Integer.parseInt(id));
        }
        Ad ad1 = adManagerService.getAdById(ad);
        model.addAttribute("ad",ad1);
        return "manager/modifyAd";
    }


    //修改功能信息
    @PostMapping("modifyAd")
    @ResponseBody
    public String modifyAd(HttpServletRequest request){
        String adname = request.getParameter("adname");
        String path = request.getParameter("path");
        String id = request.getParameter("id");
        String url = request.getParameter("url");
        Ad ad=new Ad();
        if(id!=null){
            ad.setId(Integer.parseInt(id));
        }
        ad.setPath(path);
        ad.setAdname(adname);
        ad.setUrl(url);
        int i = adManagerService.updateAd(ad);
        if(i>0) {
            return "success";
        }else{
            return "faild";
        }
    }


    //跳转到广告位管理页(分页显示)
    @RequestMapping("toadlocation")
    public String toadlocation( Integer pageNo,Integer pageSize,Model model){
        pageNo=pageNo==null?1:pageNo;
        pageSize=pageSize==null?10:pageSize;
        //获得分页对象
        PageHelper.startPage(pageNo,pageSize);
        List<Adlocation> list = adManagerService.getAdLocations();
        PageInfo<Adlocation> page=new PageInfo<Adlocation>(list);
        model.addAttribute("page",page);
        return "/manager/adlocation";
    }




}
