package com.yuliana.japaneserestaurant.service;

import com.yuliana.japaneserestaurant.service.dto.DishCategoryDto;

import java.util.List;

public interface DishCategoryService {

    /**
     * Find all dish categories.
     *
     * @return list of dish categories
     */
    List<DishCategoryDto> findAll();
}
