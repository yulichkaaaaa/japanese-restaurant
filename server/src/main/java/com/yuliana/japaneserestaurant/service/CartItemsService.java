package com.yuliana.japaneserestaurant.service;

import com.yuliana.japaneserestaurant.service.dto.CartItemsDto;

import java.util.List;

public interface CartItemsService {
    /**
     * Add item tp the cart.
     *
     * @param userId id of the user
     * @param dishId id of the dish
     */
    void addItem(int userId, int dishId);

    /**
     * Delete item from cart or increase its count depend on count of items that must be removed.
     *
     * @param userId id of the user
     * @param dishId id of the dish
     * @param count count of items that must be removed
     */
    void deleteItem(int userId, int dishId, int count);

    /**
     * Find all user's cart items.
     *
     * @param userId id of the user
     * @return list of cart items
     */
    List<CartItemsDto> findUserItems(int userId);
}
