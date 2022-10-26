package com.briup.cms.exception;


import com.briup.cms.utils.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.Service;

/**
 * 全局异常处理器 ：controller +interceptor
 *
 * 使用 AOP 实现
 * @Author lining
 * @Date 2022/10/25
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handlerException(Exception ex){
       if(ex instanceof ServiceException){

          return Result.failure(2004,ex.getMessage());
       }
        return Result.failure(10001,ex.getMessage());
    }
}
