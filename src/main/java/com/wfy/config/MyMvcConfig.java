package com.wfy.config;

import com.wfy.component.LoginHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoginHandlerInterceptor loginHandlerInterceptor;

    @Override
  public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginHandlerInterceptor)
                .excludePathPatterns("/index.html","/User/login");

    }
}
