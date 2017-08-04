package com.shigan.controller.pm;

import com.shigan.common.Common;
import com.shigan.pojo.User;
import com.shigan.pojo.pm.Wdzx;
import com.shigan.pojo.pm.Wyzs;
import com.shigan.service.UserService;
import com.shigan.service.pm.WdzxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/8/1.
 */
@Controller
@RequestMapping("pm")
public class WdzxController {

    @Autowired
    private WdzxService wdzxService;
    @Autowired
    private UserService userService;
    //跳转到我的装修列表页
    @RequestMapping("towdzx")
    public String towdzx(Model model){
        User user = Common.user;
        List<Wdzx> getwdzxbycommunityid = wdzxService.getwdzxbycommunityid(user.getCommunityid());
        for(Wdzx zx:getwdzxbycommunityid){
            User u1=new User();
            u1.setId(zx.getUserid());
            User u2=new User();
            u2.setId(zx.getCuserid());
            User user1 = userService.getUser(u1);
            User cuser1 = userService.getUser(u2);
            zx.setUser(user1);
            zx.setCuser(cuser1);
        }
        model.addAttribute("wdzx",getwdzxbycommunityid);
        return "/pm/wdzx";
    }


    //跳转到增加新日志页面
    @RequestMapping("toaddwd")
    public String toaddwd(Model model){
        List<User> users = userService.getUsers();
        model.addAttribute("users",users);
        return "/pm/addwd";
    }

    //增加新用户装修日志
    @RequestMapping("addwd")
    @ResponseBody
    public String addwd(HttpServletRequest request){
        User user = Common.user;
        String content = request.getParameter("content");
        String path = request.getParameter("path");
        String progress = request.getParameter("progress");
        String userid = request.getParameter("userid");
        SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Wdzx wdzx=new Wdzx();
        wdzx.setUserid(Integer.parseInt(userid));
        wdzx.setContent(content);
        wdzx.setProgress(Integer.parseInt(progress));
        wdzx.setCommunityid(user.getCommunityid());
        wdzx.setPath(path);
        wdzx.setCuserid(user.getId());
        wdzx.setCreatetime(sd.format(new Date()));
        int i = wdzxService.addwdzx(wdzx);
        if(i>0){
            return "success";
        }else{
            return "faild";
        }
    }


    //跳转到修改页面
    @RequestMapping("toupwd")
    public String toupzs(HttpServletRequest request,Model model){
        String id = request.getParameter("id");
        Wdzx getzsbyid = wdzxService.getwdbyid(Integer.parseInt(id));
        model.addAttribute("wdzx",getzsbyid);
        return "/pm/upwd";
    }

    //装修日志修改
    @RequestMapping("upwd")
    @ResponseBody
    public String upzs(HttpServletRequest request){
        String content = request.getParameter("content");
        String progress = request.getParameter("progress");
        String path = request.getParameter("path");
        String id = request.getParameter("id");
        Wdzx zs=new Wdzx();
        zs.setPath(path);
        zs.setContent(content);
        zs.setProgress(Integer.parseInt(progress));
        zs.setId(Integer.parseInt(id));
        int i = wdzxService.upwd(zs);
        if(i>0){
            return "success";
        }else{
            return "faild";
        }
    }


}
