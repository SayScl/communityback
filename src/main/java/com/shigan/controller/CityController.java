package com.shigan.controller;

import com.shigan.pojo.City;
import com.shigan.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2017/6/26.
 */
@Controller
@RequestMapping("city")
public class CityController {
    @Autowired
    private CityService cityService;
    @RequestMapping("getCity")
    public String getCity(Model model){
        List<City> list = cityService.getCity();
        model.addAttribute("citys",list);
        return "pages/city";
    }
}
