package com.shigan.controller.pm;

import com.shigan.common.Common;
import com.shigan.pojo.User;
import com.shigan.pojo.pm.Wyzs;
import com.shigan.service.UserService;
import com.shigan.service.pm.WyzsService;
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
 * Created by Administrator on 2017/7/31.
 */
@Controller
@RequestMapping("pm")
public class WyzsController {
    @Autowired
    private WyzsService wyzsService;
    @Autowired
    private UserService userService;

    //跳转到物业工作展示页
    @RequestMapping("towyzs")
    public String towyzs(Model model){
        User user = Common.user;
        List<Wyzs> getzsbycommunityid = wyzsService.getzsbycommunityid(user.getCommunityid());
        for(Wyzs zs:getzsbycommunityid){
            User u1=new User();
            u1.setId(user.getId());
            User user1 = userService.getUser(u1);
            zs.setName(user1.getName());
        }
        model.addAttribute("wyzs",getzsbycommunityid);
        return "/pm/wyzs";
    }

    //增加物业工作展示
    @RequestMapping("addzs")
    @ResponseBody
    public String addzs(HttpServletRequest request){
        User user = Common.user;
        String content = request.getParameter("content");
        String path = request.getParameter("path");
        String title = request.getParameter("title");
        SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Wyzs wyzs=new Wyzs();
        wyzs.setContent(content);
        wyzs.setTitle(title);
        wyzs.setPath(path);
        wyzs.setCommunityid(user.getCommunityid());
        wyzs.setUser(user.getId());
        wyzs.setCreatetime(sd.format(new Date()));
        int i = wyzsService.addzs(wyzs);
        if(i>0){
            return "success";
        }else{
            return "faild";
        }
    }

    //跳转到物业展示页
    @RequestMapping("toaddzs")
    public String toaddzs(){
        return "/pm/addzs";
    }

    //跳转到修改页面
    @RequestMapping("toupzs")
    public String toupzs(HttpServletRequest request,Model model){
        String id = request.getParameter("id");
        Wyzs getzsbyid = wyzsService.getzsbyid(Integer.parseInt(id));
        model.addAttribute("wyzs",getzsbyid);
        return "/pm/upzs";
    }

    //物业展示修改
    @RequestMapping("upzs")
    @ResponseBody
    public String upzs(HttpServletRequest request){
        String content = request.getParameter("content");
        String title = request.getParameter("title");
        String path = request.getParameter("path");
        String id = request.getParameter("id");
        Wyzs zs=new Wyzs();
        zs.setPath(path);
        zs.setContent(content);
        zs.setTitle(title);
        zs.setId(Integer.parseInt(id));
        int i = wyzsService.upzsbyid(zs);
        if(i>0){
            return "success";
        }else{
            return "faild";
        }
    }
}
