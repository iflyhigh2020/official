package com.leslie.silk.config;

import com.leslie.silk.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

  @Autowired
  private LoginInterceptor loginInterceptor;


  // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
  @Override
  public void addInterceptors(InterceptorRegistry registry) {


    registry.addInterceptor(loginInterceptor).addPathPatterns("/**");

    // super.addInterceptors(registry);    //较新Spring Boot的版本中这里可以直接去掉，否则会报错
  }

}
