package com.shigan.interceptor.pagehelper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * Created by Administrator on 2017/7/6.
 */
@Configuration
public class MybatisConf {

    @Bean
    public com.github.pagehelper.PageHelper pageHelper(){
        System.out.println("MyBatisConfiguration.pageHelper()");
        com.github.pagehelper.PageHelper pageHelper=new com.github.pagehelper.PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }
}
