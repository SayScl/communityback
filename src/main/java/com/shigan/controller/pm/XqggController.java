package com.shigan.controller.pm;

import com.shigan.pojo.User;
import com.shigan.pojo.pm.Xqgg;
import com.shigan.service.UserService;
import com.shigan.service.pm.XqggService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/7/28.
 */
@Controller
@RequestMapping("pm")
public class XqggController {

    @Autowired
    private UserService userService;
    @Autowired
    private XqggService xqggService;
    //跳转到小区公告列表页
    @RequestMapping("toxqgg")
    public String toxqgg(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("user");
        List<Xqgg> getggbycommunityid = xqggService.getggbycommunityid(user.getCommunityid());
        //查找创建者信息
        for(Xqgg gg:getggbycommunityid){
            User u=new User();
            u.setId(gg.getUser());
            User user1 = userService.getUser(u);
            gg.setUser1(user1);
        }
        model.addAttribute("xqgg",getggbycommunityid);
        return "/pm/xqgg";
    }


    //跳转到修改小区公告页面
    @RequestMapping("toupdategg")
    public String toupdategg(HttpServletRequest request, Model model){
        String id = request.getParameter("id");
        Xqgg getgginfobyid = xqggService.getgginfobyid(Integer.parseInt(id));
        model.addAttribute("xqgg",getgginfobyid);
        return "/pm/upgg";
    }

    //修改小区公告
    @PostMapping("upgg")
    @ResponseBody
    public String upgg(HttpServletRequest request){
        Xqgg xqgg=new Xqgg();
        String content = request.getParameter("content");
        String title = request.getParameter("title");
        String id = request.getParameter("id");
        String path = request.getParameter("path");
        xqgg.setContent(content);
        xqgg.setTitle(title);
        xqgg.setId(Integer.parseInt(id));
        xqgg.setPath(path);
        int i = xqggService.upgg(xqgg);
        if(i>0){
            return "success";
        }else{
            return "faild";
        }
    }

    //跳转到增加小区页
    @RequestMapping("toaddgg")
    public String toaddgg(){
        return "/pm/addgg";
    }
    //增加公告
    @RequestMapping("addgg")
    @ResponseBody
    public String addgg(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user =(User)session.getAttribute("user");
        String content = request.getParameter("content");
        String title = request.getParameter("title");
        String path = request.getParameter("path");
        Xqgg xqgg=new Xqgg();
        xqgg.setTitle(title);
        xqgg.setContent(content);
        xqgg.setPath(path);
        xqgg.setUser(user.getId());
        xqgg.setCommunityid(user.getCommunityid());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createtime = sdf.format(new Date());
        xqgg.setCreatetime(createtime);
        int i = xqggService.addgg(xqgg);
        if(i>0){
            return "success";
        }else{
            return "faild";
        }
    }
}
