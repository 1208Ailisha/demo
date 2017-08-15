package com.springboot;

import java.util.Date;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan
@MapperScan("com.springboot.db.mapper")//或者也可以在每个mapper接口上添加@Mapper注解
@EnableAutoConfiguration
//部署单独的tomcat需要集成SpringBootServletInitializer并重写configure方法
public class Application{

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/now")
    String hehe() {
        return "当前时间：" + (new Date()).toLocaleString();
    }
    
   /* @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }*/
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}