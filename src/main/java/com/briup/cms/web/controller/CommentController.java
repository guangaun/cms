package com.briup.cms.web.controller;

import com.briup.cms.bean.Article;
import com.briup.cms.bean.Comment;
import com.briup.cms.service.ICommentService;
import com.briup.cms.utils.ObjectUtils;
import com.briup.cms.utils.Result;
import com.briup.cms.web.vm.CommentVM;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "评论模块")
@RequestMapping("/auth/comment")
public class CommentController {

    @Autowired
    private ICommentService service;

    @ApiOperation(value = "新增评论")
    @PostMapping
    public Result addComment(@RequestBody CommentVM vm){
        Comment comment = ObjectUtils.vm2Bean(vm, Comment.class);

        comment.setArticles(Article.builder().id(vm.getArticleId()).build());

        if(vm.getParentId()!=null){

            comment.setParent(Comment.builder().id(vm.getParentId()).build());
        }

        service.saveOrUpdateComment(comment);
        return Result.success();
    }

    @ApiOperation(value = "编辑评论")
    @PutMapping
    public Result updateComment(Comment comment){
        service.saveOrUpdateComment(comment);
        return Result.success();
    }

    @ApiOperation(value = "批量删除评论")
    @DeleteMapping()
    public Result deleteBathById(@RequestParam List<Integer> ids){
        service.deleteCommentInBatch(ids);
        return Result.success();
    }

    @ApiOperation(value = "分页查询评论信息")
    @GetMapping
    public Result findByPage(@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize){
        Page<Comment> commentPage = service.findAll(pageNum, pageSize);
        return Result.success(commentPage);
    }

    @ApiOperation(value = "根据资讯id分页获取所有评论")
    @GetMapping
    public Result findById(@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize,@RequestParam("id") Integer id){
        Page<Comment> comments = service.findAllByArticleId(pageNum, pageSize, id);
        return Result.success(comments);
    }


}
