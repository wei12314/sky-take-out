package com.sky.controller.category;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/category")
@Slf4j
@Api(tags = "分类管理")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping()
    @ApiOperation("类别创建")
    public Result save(@RequestBody CategoryDTO categoryDTO){
        categoryService.save(categoryDTO);
        return Result.success();
    }

    @GetMapping("/page")
    @ApiOperation("类别分类查询")
    public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO){
        PageResult pageResult = categoryService.pageQuery(categoryPageQueryDTO);
        return Result.success(pageResult);
    }

    @DeleteMapping()
    @ApiOperation("根据类别ID删除类别")
    public Result deleteById(Long id){
        categoryService.deleteById(id);
        return Result.success();
    }

    @PutMapping()
    @ApiOperation("更新类别相关信息")
    public Result update(@RequestBody CategoryDTO categoryDTO){
        categoryService.update(categoryDTO);
        return Result.success();
    }

    @PostMapping("/status/{status}")
    @ApiOperation("启用、禁用类别")
    public Result startOrStop(@PathVariable Integer status, Long id){
        categoryService.startOrStop(id, status);
        return Result.success();
    }

    @GetMapping("/list")
    @ApiOperation("根据类型查询类别")
    public Result<List<Category>> findByType(Integer type){
       List<Category> categories =  categoryService.findByType(type);
       return Result.success(categories);
    }
}
