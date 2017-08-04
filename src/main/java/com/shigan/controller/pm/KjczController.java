package com.shigan.controller.pm;

import com.shigan.common.Common;
import com.shigan.pojo.User;
import com.shigan.pojo.pm.Kjcz;
import com.shigan.service.UserService;
import com.shigan.service.pm.KjczService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
@Controller
@RequestMapping("/pm")
public class KjczController {
    @Autowired
    private KjczService kjczService;
    @Autowired
    private UserService userService;

    //跳转到充值管理页
    @RequestMapping("tokjcz")
    public String tokjcz(Model model){
        User user = Common.user;
        List<Kjcz> getczbyuserid = kjczService.getczbyuserid(user.getCommunityid());
        for(Kjcz k:getczbyuserid){
            User u1=new User();
            u1.setId(k.getUserid());
            User user1 = userService.getUser(u1);
            k.setName(user1.getName());
        }
        model.addAttribute("kjcz",getczbyuserid);
        return "/pm/kjcz";
    }
    
    @RequestMapping("cz")
    public String cz(HttpServletRequest request){
        String id = request.getParameter("id");
        int cz = kjczService.cz(Integer.parseInt(id));
        return "redirect:/pm/tokjcz";
    }
}
