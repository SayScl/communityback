package com.shigan.controller.supermarket;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shigan.pojo.market.Brand;
import com.shigan.pojo.market.Category;
import com.shigan.pojo.market.Product;
import com.shigan.pojo.market.Sku;
import com.shigan.service.supermarket.BrandService;
import com.shigan.service.supermarket.ProductService;
import com.shigan.service.supermarket.SkuService;
import org.aspectj.weaver.tools.cache.SimpleCacheFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

/**
 * Created by Administrator on 2017/7/12.
 */
@Controller
@RequestMapping("market")
public class ProductController {
    @Autowired
    private SkuService skuService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private ProductService productService;

    //跳转到商品列表页
    @RequestMapping("toproduct")
    public String toproduct(Integer pageNo, Integer pageSize, Model model) {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<Product> products = productService.getproduct();
        PageInfo<Product> p = new PageInfo<Product>(products);
        model.addAttribute("page", p);
        return "/supermarket/product";
    }


    //跳转到添加商品页面
    @RequestMapping("toaddproduct")
    public String toaddproduct(Model model) {
        List<Brand> brands = brandService.getbrand();
        List<Sku> skus = skuService.getsku();
        model.addAttribute("brand", brands);
        model.addAttribute("sku", skus);
        return "/supermarket/addproduct";
    }

    //添加商品
    @RequestMapping("addproduct")
    @ResponseBody
    public String addproduct(HttpServletRequest request) {
        String productname = request.getParameter("productname");
        String brandname = request.getParameter("brandname");
        String brandid = request.getParameter("brandid");
        String skuid = request.getParameter("skuid");
        String categoryid = request.getParameter("categoryid");
        Product product = new Product();
        product.setProductname(productname);
        product.setBrandname(brandname);
        product.setBrandid(Integer.parseInt(brandid));
        product.setSkuid(Integer.parseInt(skuid));
        product.setCategoryid(Integer.parseInt(categoryid));
        product.setIsshow(1);
        product.setUpdown(0);
        int i = productService.addproduct(product);
        if (i > 0) {
            return "success";
        } else {
            return "faild";
        }
    }


    //跳转到查看页面
    @RequestMapping("toproductinfo")
    public String toproductinfo(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        Product pr = productService.getproductinfo(Integer.parseInt(id));
        model.addAttribute("product", pr);
        return "/supermarket/productinfo";
    }

    //上架
    @RequestMapping("up")
    public String up(HttpServletRequest request) {
        String id = request.getParameter("id");
        int i = productService.up(Integer.parseInt(id));

        return "redirect:/market/toproduct";

    }


    //下架
    @RequestMapping("down")
    public String down(HttpServletRequest request) {
        String id = request.getParameter("id");
        int i = productService.down(Integer.parseInt(id));

        return "redirect:/market/toproduct";

    }

    //跳转到修改商品信息页
    @RequestMapping("toupdateproduct")
    public String toupdateproduct(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");
        Product getproductinfo = productService.getproductinfo(Integer.parseInt(id));
        model.addAttribute("product", getproductinfo);
        return "/supermarket/updateproduct";
    }

    //修改商品信息
    @RequestMapping("updateproduct")
    public String updateproduct(HttpServletRequest request) {
        String id = request.getParameter("id");
        String productname = request.getParameter("productname");
        String price = request.getParameter("price");
        String store = request.getParameter("store");
        String storewarning = request.getParameter("storewarning");
        String description = request.getParameter("description");
        String path = request.getParameter("path");
        Product product = new Product();
        product.setProductname(productname);
        product.setPrice(Double.parseDouble(price));
        product.setDescription(description);
        product.setStore(Integer.parseInt(store));
        product.setStorewarning(Integer.parseInt(storewarning));
        product.setPath(path);
        product.setId(Integer.parseInt(id));
        int i = productService.updateproduct(product);
        return "redirect:/market/toproduct";
    }
}
