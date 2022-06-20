package com.yuliana.japaneserestaurant.service.impl;

import com.yuliana.japaneserestaurant.persistence.entity.CartItems;
import com.yuliana.japaneserestaurant.persistence.entity.CartItemsKey;
import com.yuliana.japaneserestaurant.persistence.entity.Dish;
import com.yuliana.japaneserestaurant.persistence.entity.User;
import com.yuliana.japaneserestaurant.persistence.repository.CartItemsRepository;
import com.yuliana.japaneserestaurant.persistence.repository.DishRepository;
import com.yuliana.japaneserestaurant.persistence.repository.UserRepository;
import com.yuliana.japaneserestaurant.service.CartItemsService;
import com.yuliana.japaneserestaurant.service.dto.CartItemsDto;
import com.yuliana.japaneserestaurant.service.dto.converter.CartItemsDtoConverter;
import com.yuliana.japaneserestaurant.service.exception.NoSuchResourceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartItemsServiceImpl implements CartItemsService {
    private final CartItemsRepository cartItemsRepository;
    private final DishRepository dishRepository;
    private final UserRepository userRepository;
    private final CartItemsDtoConverter cartItemsConverter;

    public CartItemsServiceImpl(CartItemsRepository cartItemsRepository, DishRepository dishRepository, UserRepository userRepository, CartItemsDtoConverter cartItemsConverter) {
        this.cartItemsRepository = cartItemsRepository;
        this.dishRepository = dishRepository;
        this.userRepository = userRepository;
        this.cartItemsConverter = cartItemsConverter;
    }

    @Transactional
    @Override
    public void addItem(int userId, int dishId) {
        Dish dish = dishRepository.findById(dishId).orElseThrow(NoSuchResourceException::new);
        User user = userRepository.findById(userId).orElseThrow(NoSuchResourceException::new);
        CartItemsKey cartItemsKey = new CartItemsKey(dishId, userId);
        if (cartItemsRepository.existsById(cartItemsKey)) {
            CartItems cartItems = cartItemsRepository.findById(cartItemsKey).orElseThrow();
            cartItems.setCount(cartItems.getCount() + 1);
            cartItemsRepository.save(cartItems);
        } else {
            CartItems cartItems = new CartItems();
            cartItems.setDish(dish);
            cartItems.setCount(1);
            cartItems.setUser(user);
            cartItemsRepository.save(cartItems);
        }

    }

    @Transactional
    @Override
    public void deleteItem(int userId, int dishId, int count) {
        CartItemsKey cartItemsKey = new CartItemsKey(dishId, userId);
        CartItems cartItems = cartItemsRepository.findById(cartItemsKey).orElseThrow(NoSuchResourceException::new);
        if (cartItems.getCount() == 1) {
            cartItemsRepository.delete(cartItems);
        } else {
            cartItems.setCount(cartItems.getCount() - count);
            cartItemsRepository.save(cartItems);
        }
    }

    @Override
    public List<CartItemsDto> findUserItems(int userId) {
        return cartItemsRepository
                .findByUser_UserId(userId)
                .stream()
                .map(cartItemsConverter::convertToDto)
                .collect(Collectors.toList());
    }
}
