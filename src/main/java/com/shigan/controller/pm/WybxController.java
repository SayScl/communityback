package com.shigan.controller.pm;

import com.shigan.pojo.User;
import com.shigan.pojo.pm.Wybx;
import com.shigan.service.UserService;
import com.shigan.service.pm.WybxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017/7/28.
 */
@Controller
@RequestMapping("pm")
public class WybxController {

    @Autowired
    private WybxService wybxService;
    @Autowired
    private UserService userService;
    //跳转到物业报修列表页
    @RequestMapping("towybx")
    public String towybx(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("user");
        //获得登录物管的小区id
        Integer communityid = user.getCommunityid();
        List<Wybx> list = wybxService.getbxbycommunityid(communityid);
        //查找报修人的相关信息
        for(Wybx l:list){
            User u1=new User();
            Integer userid = l.getUserid();
            u1.setId(userid);
            User user1 = userService.getUser(u1);
            l.setUser(user1);
        }
        model.addAttribute("wybx",list);
        return "/pm/wybx";
    }


    //接受报修
    @PostMapping("acceptbx")
    @ResponseBody
    public String acceptbx(HttpServletRequest request){
        String id = request.getParameter("id");
        Wybx bx=new Wybx();
        bx.setId(Integer.parseInt(id));
        bx.setStatu(1);
        int i = wybxService.acceptbx(bx);
        if(i>0){
            return "success";
        }else{
            return "faild";
        }
    }

}
