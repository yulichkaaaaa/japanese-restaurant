package com.yuliana.japaneserestaurant.service;

import com.yuliana.japaneserestaurant.service.dto.DishDto;

import java.util.List;

public interface FavoritesService {
    /**
     * Delete dish from user's favorites list by it's ids.
     *
     * @param dishId id of the dish
     * @param userId id of the user
     */
    void deleteDishFromFavorites(int dishId, int userId);

    /**
     * Add the dish to user's favorites list by it's ids.
     *
     * @param dishId id of the dish
     * @param userId id of the user
     */
    void addDishToFavorites(int dishId, int userId);

    /**
     * Find all the dishes that are in the user's favorites list by user's id.
     *
     * @param userId id of the user
     * @return list of the dishes
     */
    List<DishDto> findUserFavorites(int userId);
}
