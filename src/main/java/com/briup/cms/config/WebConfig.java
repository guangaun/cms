package com.briup.cms.config;


import com.briup.cms.web.interceptor.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置类:等效xml配置文件
 * @Author lining
 * @Date 2022/10/25
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /*为springMVC添加一个拦截器*/

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("spirngboot添加jwt拦截器");
        //1.通过注册对象提供拦截对象及拦截规则
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns("/auth/**");

        //登录  /login    //其他请求  /auth/student /auth/teacher
    }
}
