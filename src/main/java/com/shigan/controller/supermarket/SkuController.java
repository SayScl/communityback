package com.shigan.controller.supermarket;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shigan.pojo.market.Property;
import com.shigan.pojo.market.Sku;
import com.shigan.pojo.market.Skuproperty;
import com.shigan.service.supermarket.PropertyService;
import com.shigan.service.supermarket.SkuService;
import com.shigan.service.supermarket.SkupropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */
@Controller
@RequestMapping("market")
public class SkuController {

    @Autowired
    private PropertyService propertyService;
    @Autowired
    private SkupropertyService skupropertyService;
    @Autowired
    private SkuService skuService;
    @RequestMapping("tosku")
    public String tosku(Integer pageNo, Integer pageSize, Model model){
        pageNo=pageNo==null?1:pageNo;
        pageSize=pageSize==null?10:pageSize;
        PageHelper.startPage(pageNo,pageSize);
        List<Sku> skus = skuService.getsku();
        PageInfo<Sku> p=new PageInfo<Sku>(skus);
        model.addAttribute("page",p);
        return "/supermarket/sku";
    }

    @RequestMapping("toaddsku")
    public String toaddsku(Model model){
        List<Skuproperty> skuproperties = skupropertyService.getskuproperty();
        for(Skuproperty s:skuproperties){
            String propertyids = s.getPropertyids();
            //将属性值集转成数组
            if(propertyids!=null){
                String[] pro = propertyids.split(",");
                List list=new ArrayList();
                Property p=new Property();
                //将属性集值加入到property中
                for(int i=0;i<pro.length;i++){
                    list.add(pro[i]);
                }
                p.setIds(list);
                //通过属性集值集合查到propertys
                List<Property> list1 = propertyService.getpropertybyid(p);
                s.setPropertys(list1);
            }else {
                continue;
            }
        }
        model.addAttribute("list",skuproperties);
        return "supermarket/addsku";
    }

    @RequestMapping("addsku")
    @ResponseBody
    public String addsku(HttpServletRequest request){
        Sku sku=new Sku();
        String skuname = request.getParameter("skuname");
        String price = request.getParameter("price");
        if(price!=null){
            sku.setPrice(Double.parseDouble(price));
        }
        String store = request.getParameter("store");
        String storewarning = request.getParameter("storewarning");
        String propertyid = request.getParameter("propertyid");
        String description = request.getParameter("description");
        String path = request.getParameter("path");
        sku.setSkuname(skuname);
        if(store!=null){
            sku.setStore(Integer.parseInt(store));
        }

        if(storewarning!=null){
            sku.setStorewarning(Integer.parseInt(storewarning));
        }
        sku.setPropertyid(propertyid);
        sku.setDescription(description);
        sku.setPath(path);
        int i = skuService.addsku(sku);
        if(i>0){
            return "success";
        }else{
            return "faild";
        }

    }
}
