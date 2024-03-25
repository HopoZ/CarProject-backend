package com.carproject.config;

import com.carproject.interceptor.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                //拦截
                .addPathPatterns("/user/test")
                .addPathPatterns("/WCMP/getDetailedData")
                //放行
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/register")
                .excludePathPatterns("/web/getDetailedData")
                .excludePathPatterns("/web/getCarDataList")
                .excludePathPatterns("/web/registerCar ");
    }
}