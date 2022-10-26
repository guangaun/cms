package com.briup.cms.web.controller;

import com.briup.cms.service.IUserService;
import com.briup.cms.utils.Result;
import com.briup.cms.utils.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "登录模块")
@RestController
public class LoginController {

    @Autowired
    private IUserService userService;
    @ApiOperation(value = "用户登录")
    @PostMapping(value = "/login",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Result login(String username,String password){
        String token = userService.login(username, password);

        return Result.success(ResultCode.SUCCESS,token);


    }

}
