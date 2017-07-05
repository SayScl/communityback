package com.shigan.controller;

import com.shigan.pojo.Function;
import com.shigan.pojo.User;
import com.shigan.service.FunctionService;
import com.shigan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017/6/28.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private FunctionService functionService;

    @RequestMapping("/login")
    public String getUser(Model model,HttpServletRequest request, @RequestParam String phoneNumber, @RequestParam String password){
        User user=new User();
        user.setPhoneNumber(phoneNumber);
        user.setPassword(password);
        HttpSession session = request.getSession();
        User u1 = userService.getUser(user);
        if(u1!=null){
            List<Function> list = functionService.getFunction(u1.getRoleid());
            /*model.addAttribute("list",list);*/
            session.setAttribute("user",u1);
            session.setAttribute("list",list);
            return "firstPageBack";
        }else{
            model.addAttribute("faild","登录失败");
            return "redirect:/back";
        }
    }
}
