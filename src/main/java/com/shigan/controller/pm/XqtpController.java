package com.shigan.controller.pm;

import com.shigan.common.Common;
import com.shigan.pojo.User;
import com.shigan.pojo.pm.Se;
import com.shigan.pojo.pm.Xqtp;
import com.shigan.service.pm.XqtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/8/1.
 */
@Controller
@RequestMapping("pm")
public class XqtpController {
    @Autowired
    private XqtpService xqtpService;

    @RequestMapping("toxqtp")
    public String toxqtp(Model model){
            User user = Common.user;
            List<Xqtp> gettpbycommunityid = xqtpService.gettpbycommunityid(user.getCommunityid());
            model.addAttribute("xqtp",gettpbycommunityid);
            return "/pm/xqtp";

    }


    //跳转到新增投票页
    @RequestMapping("toaddtp")
    public String toaddtp(Model model, @ModelAttribute("xqtp") Xqtp xqtp){
        if(xqtp.getId()!=null){
            Xqtp xqtp1 = xqtpService.gettpbyid(xqtp.getId());
            model.addAttribute("xqtp",xqtp1);
            return "/pm/addtp";
        }else{
            return "/pm/addtp";
        }


    }


    //添加投票
    @RequestMapping("addtp")
    @ResponseBody
    public String addtp(HttpServletRequest request){
        User user = Common.user;
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String cnum = request.getParameter("cnum");
        String type = request.getParameter("type");
        SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String limittime = request.getParameter("limittime");
        Xqtp tp=new Xqtp();
        tp.setTitle(title);
        tp.setContent(content);
        tp.setType(Integer.parseInt(type));
        tp.setCnum(Integer.parseInt(cnum));
        tp.setCommunityid(user.getCommunityid());
        tp.setCreatetime(sd.format(new Date()));
        tp.setConfirm(1);
        tp.setLimittime(limittime);
        int i = xqtpService.addtp(tp);
        if(i>0){
            int getid = xqtpService.getid(tp);
            String a=String.valueOf(getid);
            return a;
        }else{
            return "faild";
        }
    }


    //跳转到增加选项页
    @RequestMapping("toaddse")
    public String toaddse(HttpServletRequest request,Model model){
        String id = request.getParameter("id");
        model.addAttribute("id",id);
        return "/pm/addse";
    }


    //增加投票选项
    @RequestMapping("addse")
    public String addse(HttpServletRequest request, RedirectAttributes attr){
        String path = request.getParameter("path");
        String[] path1 = path.split(",");
        String content = request.getParameter("content");
        String tid = request.getParameter("id");
        String[] split = content.split(",");
        List<Se> sel=new ArrayList<Se>();
        for(int i=0;i<split.length;i++){
            Se se=new Se();
            se.setContent(split[i]);
            se.setPath(path1[i]);
            se.setProgress(0);
            se.setTid(Integer.parseInt(tid));
            sel.add(se);
        }
        int i = xqtpService.addse(sel);
        if(i>0){
            attr.addAttribute("id",tid);
            return "redirect:/pm/toaddtp";
        }else{
            return "/pm/toaddtp";
        }
    }

    //最后一步确认投票成功（修改信息）
    @RequestMapping("uptp")
    @ResponseBody
    public String uptp(HttpServletRequest request){
        String id = request.getParameter("id");
        List<Se> getsebyftid = xqtpService.getsebyftid(Integer.parseInt(id));
        String se="";
        for(int i=0;i<getsebyftid.size();i++){
            if(i==0){
                se=se+getsebyftid.get(0).getId();
            }else{
                se=se+","+getsebyftid.get(i).getId();
            }
        }
        Xqtp tp=new Xqtp();
        tp.setSe(se);
        tp.setId(Integer.parseInt(id));
        int i = xqtpService.uptp(tp);
        if(i>0){
            return "success";
        }else{
            return "faild";
        }
    }
}
