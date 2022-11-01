package com.briup.cms.web.controller;


import com.briup.cms.bean.Article;
import com.briup.cms.service.IArticleService;
import com.briup.cms.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "资讯模块")
@RestController
@RequestMapping("/auth/article")
public class ArticleController {

    @Autowired
    private IArticleService service;

    @ApiOperation(value = "新增资讯")
    @PostMapping
    public Result addArticle(Article article){
        service.saveOrUpdateArticle(article);
        return Result.success();
    }

    @ApiOperation(value = "编辑资讯")
    @PutMapping
    public Result updateArticle(Article article){
        service.saveOrUpdateArticle(article);
        return Result.success();

    }
    @ApiOperation(value = "根据类别ID查询，分页获取资讯信息，并且按照阅读量降序排")
    @GetMapping()
    public Result findById(@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize,@RequestParam("CategoryId") Integer CategoryId ){
        return Result.success();
    }
//    @ApiOperation(value = "根据用户分页获取资讯信息")
//    @GetMapping
//    public Result findAllByPage(){
//
//        return Result.success();
//    }

    @ApiOperation(value = "批量删除资讯")
    @DeleteMapping()
    public Result deleteBath(){
        return Result.success();
    }

    @ApiOperation(value = "审核资讯")
    @GetMapping("/status")
    public Result findByStatus(@RequestParam("id") Integer id,@RequestParam("status") String status){
        service.updateArticleStatus(id,status);
        return Result.success();
    }



}
