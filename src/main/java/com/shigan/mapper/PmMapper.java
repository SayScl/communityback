package com.shigan.mapper;

import com.shigan.pojo.pm.*;
import com.shigan.service.pm.XfzxService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/7/28.
 */
@Component
@Mapper
public interface PmMapper {

    //<!--查询该小区的报修情况-->
    public List<Wybx> getbxbycommunityid(Integer communityid);

    //<!--接受报修-->
    public int acceptbx(Wybx wybx);


    //<!--根据小区Id查小区公告-->
    public List<Xqgg> getggbycommunityid(Integer communityid);

    //根据公告id查看公告详细信息
    public Xqgg getgginfobyid(Integer id);

    //<!--根据id修改公告内容-->
    public int upgg(Xqgg xqgg);

    //<!--增加小区公告-->
    public int addgg(Xqgg xqgg);




        //<!--修改小区物业展示内容-->
  public int  upzsbyid(Wyzs wyzs);

    //<!--增加小区物业工作展示-->
    public int addzs(Wyzs wyzs);
    //<!--小区物业展示-->
   public List<Wyzs> getzsbycommunityid(Integer communityid);

   //<!--根据id查物业工作展示-->
    public Wyzs getzsbyid(Integer id);


    //<!--根据小区Id查找该小区的新房装修信息-->
    public List<Xfzx> getzxbycommunity(Integer communityid);


     //<!--查找小区要充值的记录-->
    public List<Kjcz> getczbyuserid(Integer communityid);

    //<!--充值修改充值状态-->
    public int cz(Integer id);



       //<!--查看该小区的装修风格-->
    public List<Xfzx> getxfzxbycommunityid(Integer communityid);


    //<!--增加装修风格-->
    public int addxfzx(Xfzx xfzx);


    //<!--根据id修改装修风格-->
   public int  upxfzxbyid(Xfzx xfzx);

    //<!--根据id查找装修风格-->
    public Xfzx getxfbyid(Integer id);



    //<!--查找该小区的个人装修日志-->
    public List<Wdzx> getwdzxbycommunityid(Integer communityid);


    //<!--根据id查找装修日志-->
    public Wdzx getwdbyid(Integer id);


    //<!--新增住户装修日志-->
   public int addwdzx(Wdzx wdzx);


    //<!--根据id修改装修日志-->
    public int upwd(Wdzx wdzx);


    //<!--查看该小区的投票-->
    public List<Xqtp> gettpbycommunityid(Integer communityid);


    //<!--增加新的投票-->
    public int addtp(Xqtp xqtp);

     //<!--根据id查找投票-->
    public Xqtp gettpbyid(Integer id);


     // <!--修改投票信息-->
    public int uptp(Xqtp xqtp);


    //<!--增加选项-->
    public int addse(List<Se> se);

    //<!--投票保存后查找这个投票id-->
    public int getid(Xqtp xqtp);

     //<!--根据tid查选项-->
    public List<Se> getsebyftid(Integer tid);

}
