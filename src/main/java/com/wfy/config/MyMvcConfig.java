package com.wfy.config;

import com.wfy.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @Author wfy
 * @Description: 注册自定义拦截器
 * @Date 23:47 2021/01/23
 **/
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Resource
    private LoginHandlerInterceptor loginHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(loginHandlerInterceptor)
                    .excludePathPatterns("/index.html","/User/login");

    }
}
