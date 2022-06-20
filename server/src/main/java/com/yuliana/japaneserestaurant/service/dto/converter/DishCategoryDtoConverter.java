package com.yuliana.japaneserestaurant.service.dto.converter;

import com.yuliana.japaneserestaurant.persistence.entity.DishCategory;
import com.yuliana.japaneserestaurant.service.dto.DishCategoryDto;
import org.springframework.stereotype.Component;

@Component
public class DishCategoryDtoConverter implements DtoConverter<DishCategoryDto, DishCategory> {

    @Override
    public DishCategoryDto convertToDto(DishCategory dishCategory) {
        return new DishCategoryDto(dishCategory.getDishCategoryId(), dishCategory.getName());
    }

    @Override
    public DishCategory convertToEntity(DishCategoryDto dishCategoryDto) {
        return new DishCategory(dishCategoryDto.getDishCategoryId(), dishCategoryDto.getName());
    }
}
