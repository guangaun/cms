package com.briup.cms.web.controller;

import com.briup.cms.bean.Category;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "目录模块")
@RestController
@RequestMapping("/auth/category")
public class CategoryController {

    @Autowired
    private ICategoryService service;


    @ApiOperation(value = "新增或修改目录信息")
    @PostMapping
    private Result saveOrUpdateCategory(@RequestBody Category category){
        service.saveOrUpdateCategory(category);

        return Result.success();
    }

    @ApiOperation(value = "按照序号升序分页查询目录信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页码",defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小",defaultValue = "10"),
    })
    @GetMapping("/page")
    public Result findByPage(@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize){
        Page<Category> page = service.findAllSortByNo(pageNum, pageSize);
        return Result.success(page);
    }

    @ApiOperation(value = "批量删除目录信息")
    @DeleteMapping
    public Result deleteByBatch(@RequestParam List<Integer> ids){
        service.deleteCategoryInBatch(ids);
        return Result.success();
    }

    @ApiOperation(value = "更新目录序号信息")
    @GetMapping("/no")
    public Result updateNoById(@RequestParam("id") Integer id,@RequestParam("no") Integer no){
        service.updateCategoryNo(id, no);
        return Result.success();
    }


//    public Category vmToBean(CategoryVm vm){
//        return null;
//    }

}
