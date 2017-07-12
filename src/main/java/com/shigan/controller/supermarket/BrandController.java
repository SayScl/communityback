package com.shigan.controller.supermarket;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shigan.pojo.market.Brand;
import com.shigan.service.supermarket.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */
@Controller
@RequestMapping("market")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping("tobrand")
    public String tobrand(Integer pageNo, Integer pageSize, Model model){
        pageNo=pageNo==null?1:pageNo;
        pageSize=pageSize==null?10:pageSize;
        PageHelper.startPage(pageNo,pageSize);
        List<Brand> brands = brandService.getbrand();
        PageInfo<Brand> p=new PageInfo<Brand>(brands);
        model.addAttribute("page",p);
        return "/supermarket/brand";
    }
}
