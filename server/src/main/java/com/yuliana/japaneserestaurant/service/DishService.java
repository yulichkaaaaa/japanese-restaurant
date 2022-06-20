package com.yuliana.japaneserestaurant.service;

import com.yuliana.japaneserestaurant.service.dto.DishCategoryDto;
import com.yuliana.japaneserestaurant.service.dto.DishDto;

import java.util.List;

public interface DishService {
    /**
     * Find dish by its id.
     *
     * @param dishId id of the dish
     * @return the {@code Dish} object
     */
    DishDto findDishById(int dishId);

    /**
     * Find all rhe dishes.
     *
     * @return list of the dishes
     */
    List<DishDto> findAllDishes(String sortType, String sortDirection, short categoryId);

    /**
     * Find the dishes by its name part. Validate the input.
     *
     * @param name part of the name of the dish
     * @return list of the dishes
     */
    List<DishDto> findDishesByName(String name);

    /**
     * Delete the dish by its id.
     *
     * @param dishId id of the dish
     */
    void deleteDishById(int dishId);

    /**
     * Add dish entity.
     *
     * @param dishDto the {@code DishDto} object
     * @return id of created dish entity
     */
    int addDishToMenu(DishDto dishDto);

    /**
     * Edit dish entity.
     *
     * @param dishDto the {@code DishDto} object
     */
    void editDish(DishDto dishDto);
}
