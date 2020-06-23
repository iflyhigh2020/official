package com.leslie.silk;

import java.util.ArrayList;
import java.util.List;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@SpringBootApplication
@MapperScan("com.leslie.silk.mapper")
public class SilkApplication {

  public static void main(String[] args) {
    SpringApplication.run(SilkApplication.class, args);
  }

  @Bean
  public MappingJackson2HttpMessageConverter jackson2HttpMessageConverter()
  {
    MappingJackson2HttpMessageConverter bean = new MappingJackson2HttpMessageConverter();
    bean.setPrefixJson(false);

    //设置中文编码格式
    List<MediaType> list = new ArrayList<MediaType>();
    list.add(MediaType.APPLICATION_JSON_UTF8);
    list.add(MediaType.TEXT_HTML);
    bean.setSupportedMediaTypes(list);
    return bean;
  }
}
