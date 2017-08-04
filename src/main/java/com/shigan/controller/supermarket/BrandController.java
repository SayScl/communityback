package com.shigan.controller.supermarket;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shigan.pojo.market.Brand;
import com.shigan.pojo.market.Category;
import com.shigan.service.supermarket.BrandService;
import com.shigan.service.supermarket.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */
@Controller
@RequestMapping("market")
public class BrandController {
    @Autowired
    private CategoryService categoryService;

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

    //跳转到增加品牌页
    @RequestMapping("toaddbrand")
    public String toaddbrand(Model model){
        List<Category> getcategory = categoryService.getcategory();
        model.addAttribute("category",getcategory);
        return "/supermarket/addbrand";
    }

    @RequestMapping("addbrand")
    @ResponseBody
    public String addbrand(HttpServletRequest request){
        String brandname = request.getParameter("brandname");
        String id = request.getParameter("id");
        Brand br =new Brand();
        br.setBrandname(brandname);
        br.setCategoryid(Integer.parseInt(id));
        br.setIsshow(1);
        int i = brandService.addbrand(br);
        if(i>0){
            return "success";

        }else{
            return "faild";
        }
    }
}
