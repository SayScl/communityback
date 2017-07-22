package com.shigan.controller;

import com.shigan.service.supermarket.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/6/27.
 */
@Controller
public class FirstPageBack {

    @RequestMapping("/back")
    public String firstPage(@ModelAttribute("faild") String faild,Model model){
        model.addAttribute("faild",faild);
        return "login";
    }
}
