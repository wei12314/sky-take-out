package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;

import java.util.List;

public interface CategoryService {
    void save(CategoryDTO categoryDTO);

    PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    void deleteById(Long id);

    void update(CategoryDTO categoryDTO);

    void startOrStop(Long id, Integer status);

    List<Category> findByType(Integer type);
}
