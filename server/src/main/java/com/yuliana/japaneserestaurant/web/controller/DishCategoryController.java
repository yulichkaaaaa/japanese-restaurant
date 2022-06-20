package com.yuliana.japaneserestaurant.web.controller;

import com.yuliana.japaneserestaurant.service.DishCategoryService;
import com.yuliana.japaneserestaurant.service.dto.DishCategoryDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class DishCategoryController {

    private final DishCategoryService dishCategoryService;

    public DishCategoryController(DishCategoryService dishCategoryService) {
        this.dishCategoryService = dishCategoryService;
    }

    @GetMapping
    public List<DishCategoryDto> findAll() {
        return dishCategoryService.findAll();
    }
}
