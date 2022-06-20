package com.yuliana.japaneserestaurant.service.dto.converter;

import com.yuliana.japaneserestaurant.persistence.entity.Dish;
import com.yuliana.japaneserestaurant.persistence.entity.DishCategory;
import com.yuliana.japaneserestaurant.service.dto.DishCategoryDto;
import com.yuliana.japaneserestaurant.service.dto.DishDto;
import org.springframework.stereotype.Component;

@Component
public class DishDtoConverter implements DtoConverter<DishDto, Dish> {
    @Override
    public DishDto convertToDto(Dish dish) {
        DishCategory dishCategory = dish.getCategory();
        DishCategoryDto dishCategoryDto = new DishCategoryDto(dishCategory.getDishCategoryId(), dishCategory.getName());
        return new DishDto(dish.getDishId(), dish.getName(), dishCategoryDto, dish.getPictureName(), dish.getPrice(), dish.getDiscountPercents(), dish.getDateAdded(), dish.getDescription(), dish.getWeight());
    }

    @Override
    public Dish convertToEntity(DishDto dishDto) {
        DishCategoryDto dishCategoryDto = dishDto.getCategory();
        DishCategory dishCategory = new DishCategory(dishCategoryDto.getDishCategoryId(), dishCategoryDto.getName());
        return new Dish(dishDto.getDishId(), dishDto.getName(), dishCategory, dishDto.getPictureName(), dishDto.getPrice(), dishDto.getDiscountPercents(), dishDto.getDateAdded(), dishDto.getDescription(), dishDto.getWeight());
    }
}
