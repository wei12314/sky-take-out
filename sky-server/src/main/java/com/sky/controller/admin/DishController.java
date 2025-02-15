package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/dish")
@Api(tags = "菜品管理")
@Slf4j
public class DishController {
    @Autowired
    private DishService dishService;
    @PostMapping
    public Result save(@RequestBody DishDTO dishDTO){
        log.info("保存菜品: {}", dishDTO);
        dishService.saveWithFlavor(dishDTO);
        return Result.success();
    }

    @GetMapping("/page")
    public Result<PageResult> page(DishPageQueryDTO dishPageQueryDTO){
       PageResult pageResult = dishService.pageQuery(dishPageQueryDTO);
        return Result.success(pageResult);
    }

    @DeleteMapping()
    public Result deleteByIds(@RequestParam List<Long> ids){
        dishService.deleteByIds(ids);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result<DishVO> findById(@PathVariable Long id){
        DishVO dishVO = dishService.findById(id);
        return Result.success(dishVO);
    }
    @PutMapping()
    public Result update(@RequestBody DishDTO dishDTO){
        dishService.update(dishDTO);
        return Result.success();
    }
    @PostMapping("/status/{status}")
    public Result startOrStop(Long id, @PathVariable Integer status){
        dishService.startOrStop(id, status);
        return Result.success();
    }
}
