package com.briup.cms.web.interceptor;


import com.briup.cms.utils.JwtUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器1.必须实现一个拦截接口
 * 2.根据业务需要。拦截在什么时候，pre post after
 * 3.验证不通过，抛出异常，由全局异常处理器处理，返回统一格式
 * 4.创建出拦截器对象，交给spring  @Bean @Commpont
 * 5.设置拦截器的拦截规则 路径
 * jwt :json web token
 * @Author lining
 * @Date 2022/10/25
 */
public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断请求是否包含token 是否合法，然后进行访问controller

        //1.通过用户的请求报文中的请求头获取到发送过来的token字符串
        String token = request.getHeader("token");
        //2.进行判断：
        if(token == null){
            throw new RuntimeException("token无效，请重新登录");
        }
        //3.当用户提供了该token,进行验证
        JwtUtil.checkSign(token);//如果验证失败，抛出异常对象表示 token无效

        //4.验证通过，继续访问controller中方法
        return true;
    }
}
