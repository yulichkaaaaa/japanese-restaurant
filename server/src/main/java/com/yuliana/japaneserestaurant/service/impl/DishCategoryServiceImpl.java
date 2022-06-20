package com.yuliana.japaneserestaurant.service.impl;

import com.yuliana.japaneserestaurant.persistence.entity.DishCategory;
import com.yuliana.japaneserestaurant.persistence.repository.DishCategoryRepository;
import com.yuliana.japaneserestaurant.service.DishCategoryService;
import com.yuliana.japaneserestaurant.service.dto.DishCategoryDto;
import com.yuliana.japaneserestaurant.service.dto.converter.DishCategoryDtoConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DishCategoryServiceImpl implements DishCategoryService {

    private final DishCategoryRepository dishCategoryRepository;
    private final DishCategoryDtoConverter categoryConverter;

    public DishCategoryServiceImpl(DishCategoryRepository dishCategoryRepository, DishCategoryDtoConverter categoryConverter) {
        this.dishCategoryRepository = dishCategoryRepository;
        this.categoryConverter = categoryConverter;
    }

    @Override
    public List<DishCategoryDto> findAll() {
        List<DishCategory> categories = (List<DishCategory>) dishCategoryRepository.findAll();
        return categories.stream().map(categoryConverter::convertToDto).collect(Collectors.toList());
    }
}
