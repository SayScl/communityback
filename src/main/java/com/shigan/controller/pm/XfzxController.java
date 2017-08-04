package com.shigan.controller.pm;

import com.shigan.common.Common;
import com.shigan.pojo.User;
import com.shigan.pojo.pm.Wyzs;
import com.shigan.pojo.pm.Xfzx;
import com.shigan.service.pm.XfzxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/7/29.
 */
@Controller
@RequestMapping("pm")
public class XfzxController {

    @Autowired
    private XfzxService xfzxService;
    //跳转新房装修页
    @RequestMapping("toxfzx")
    public String toxfzx(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        User user =(User)session.getAttribute("user");
        List<Xfzx> getzxbycommunityid = xfzxService.getxfzxbycommunityid(user.getCommunityid());
        model.addAttribute("xfzx",getzxbycommunityid);
        return "/pm/xfzx";
    }

    //跳转到增加新房页
    @RequestMapping("toaddxf")
    public String toaddxf(){
        return "/pm/addxf";
    }


    //增加装修模板
    @RequestMapping("addxf")
    @ResponseBody
    public String addxf(HttpServletRequest request){
        User user = Common.user;
        String content = request.getParameter("content");
        String path = request.getParameter("path");
        String title = request.getParameter("title");
        SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Xfzx xfzx=new Xfzx();
        xfzx.setContent(content);
        xfzx.setPath(path);
        xfzx.setTitle(title);
        xfzx.setUser(user.getId());
        xfzx.setCreatetime(sd.format(new Date()));
        xfzx.setCommunityid(user.getCommunityid());
        xfzx.setHot(1);
        int i = xfzxService.addxfzx(xfzx);
        if(i>0){
            return "success";
        }else{
            return "faild";
        }
    }


    //跳转到修改页面
    @RequestMapping("toupxf")
    public String toupzs(HttpServletRequest request,Model model){
        String id = request.getParameter("id");
        Xfzx getzsbyid = xfzxService.getxfbyid(Integer.parseInt(id));
        model.addAttribute("xfzx",getzsbyid);
        return "/pm/upxf";
    }


    //修改新房装修
    @RequestMapping("upxf")
    @ResponseBody
    public String upxf(HttpServletRequest request){
        String content = request.getParameter("content");
        String title = request.getParameter("title");
        String path = request.getParameter("path");
        String id = request.getParameter("id");
        Xfzx zs=new Xfzx();
        zs.setPath(path);
        zs.setContent(content);
        zs.setTitle(title);
        zs.setId(Integer.parseInt(id));
        int i = xfzxService.upxfzxbyid(zs);
if(i>0){
    return "success";
}else{
    return "faild";
}
    }

}
