package com.briup.cms.web.controller;


import com.briup.cms.bean.User;
import com.briup.cms.service.IUserService;
import com.briup.cms.utils.JwtUtil;
import com.briup.cms.utils.Result;
import com.briup.cms.utils.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Api(tags = "用户信息管理")
@RestController
@RequestMapping("/auth/user")
public class UserController {

    @Autowired
    private IUserService service;

    @ApiOperation(value = "分页查询用户信息")
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码",defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小",defaultValue = "1"),
    })
    public Result findAllPage(Integer pageNum, Integer pageSize){
        Page<User> userPage = service.getAll(pageNum, pageSize);
        return Result.success(ResultCode.SUCCESS,userPage);
    }

    @ApiOperation(value = "新增用户信息")
    @PostMapping
    public Result saveUser(@RequestBody User user){
        service.saveOrUpdateUser(user);
        return Result.success(user);
    }
    @ApiOperation(value = "修改用户信息")
    @PutMapping
    public Result updateUser(@RequestBody User user){
        service.saveOrUpdateUser(user);
        return Result.success();
    }

    @ApiOperation(value = "批量删除用户信息")
    @DeleteMapping
    public Result deleteBathById(@RequestParam List<Integer> ids){
        service.deleteUserInBatch(ids);
        return Result.success();
    }

    @ApiOperation(value = "禁用或解封用户状态")
    @GetMapping("/status")
    public Result updateUserStatus( Integer id, String status){
        service.updateUserStatus(id,status);
        return Result.success();
    }

    @ApiOperation(value = "获得当前登录用户信息")
    @GetMapping("/current")
    public Result findCurrentUser(@ApiIgnore @RequestHeader String token){
        String username = JwtUtil.getUserId(token);
        User user = service.findUserByUsername(username);
        return Result.success(user);
    }

}
