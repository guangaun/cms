package com.briup.cms.web.controller;


import com.briup.cms.bean.User;
import com.briup.cms.service.impl.UserService;
import com.briup.cms.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户信息管理")
@RestController
@RequestMapping("/auto/user")
public class UserController {

    @Autowired
    private UserService service;

    @ApiOperation(value = "分页查询用户信息")
    @GetMapping
    public Result findAllPage(Integer pageNum, Integer pageSize){
        Page<User> userPage = service.getAll(pageNum, pageSize);
        return Result.success(userPage);
    }

    @ApiOperation(value = "新增用户信息")
    @PostMapping
    public Result saveUser(@RequestBody User user){
        service.saveOrUpdateUser(user);
        return Result.success();
    }
    @ApiOperation(value = "编辑用户信息")
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

    @ApiOperation(value = "禁用或解封用户转态")
    @GetMapping("/status")
    public Result updateUserStatus(@RequestParam("id") Integer id,@RequestParam("status") String status){
        service.updateUserStatus(id,status);
        return Result.success();
    }

}
