package com.shigan;

import com.shigan.interceptor.UserSecurityInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class CommunitybackApplication extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {

		SpringApplication.run(CommunitybackApplication.class, args);
	}


	public void addInterceptors (InterceptorRegistry interceptorRegistry){

		interceptorRegistry.addInterceptor(new UserSecurityInterceptor()).addPathPatterns("/muser/**");
	}
}

