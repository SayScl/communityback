package com.shigan.controller.supermarket;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shigan.pojo.market.Category;
import com.shigan.service.supermarket.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/7/7.
 */
@Controller
@RequestMapping("market")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //跳转到分类页
    @RequestMapping("tocategory")
    public String getcategory(Integer pageNo, Integer pageSize, Model model){
        pageNo=pageNo==null?1:pageNo;
        pageSize=pageSize==null?10:pageSize;
        PageHelper.startPage(pageNo,pageSize);
        List<Category> categories = categoryService.getcategory();
        PageInfo<Category> p=new PageInfo<Category>(categories);
        model.addAttribute("page",p);
        return "/supermarket/category";
    }


    //跳转到增加分类页
    @RequestMapping("toaddcategory")
    public String toaddcategory(){
        return "/supermarket/addcategory";
    }

    //增加分类
    @RequestMapping("addcategory")
    @ResponseBody
    public String addcategory(HttpServletRequest request){
        String categoryname = request.getParameter("categoryname");
        Category category=new Category();
        category.setCategoryname(categoryname);
        //查看是否存在
        Category j = categoryService.getcategorybyname(category);
        if(j!=null){
            category.setIsshow(1);
            int k = categoryService.updatecategory(category);
            if(k>0){
                return "success";
            }else{
                return "faild";
            }
        }else{
            category.setIsshow(1);
            int i = categoryService.addcategory(category);
            if(i>0){
                return "success";
            }else{
                return "faild";
            }
        }
    }

    //按名字查找分类
    @RequestMapping("testcategory")
    @ResponseBody
    public String getcategorybyname(HttpServletRequest request){
        String categoryname = request.getParameter("categoryname");
        Category category=new Category();
        category.setCategoryname(categoryname);
        Category category1 = categoryService.getcategorybyname(category);
        if(category1!=null){
            return "have";
        }else{
            return "no";
        }
    }

    //删除分类
    @RequestMapping("deletecategory")
    public String deletecategory(HttpServletRequest request){
        String id = request.getParameter("id");
        Category ca=new Category();
        ca.setId(Integer.parseInt(id));
        ca.setIsshow(0);
        int i = categoryService.delcategory(ca);
        return "redirect:/market/tocategory";

    }

    //修改信息
    @RequestMapping("updatecategory")
    @ResponseBody
    public String updatecategory(HttpServletRequest request){
        String id = request.getParameter("id");
        Category ca=new Category();
        ca.setId(Integer.parseInt(id));
        int i = categoryService.updatecategory(ca);
        if(i>0){
            return "success";
        }else {
            return "faild";
        }
    }

}
