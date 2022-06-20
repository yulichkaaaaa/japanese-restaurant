package com.yuliana.japaneserestaurant.service.impl;

import com.yuliana.japaneserestaurant.persistence.entity.Dish;
import com.yuliana.japaneserestaurant.persistence.entity.User;
import com.yuliana.japaneserestaurant.persistence.repository.DishRepository;
import com.yuliana.japaneserestaurant.persistence.repository.UserRepository;
import com.yuliana.japaneserestaurant.service.FavoritesService;
import com.yuliana.japaneserestaurant.service.dto.DishDto;
import com.yuliana.japaneserestaurant.service.dto.converter.DishDtoConverter;
import com.yuliana.japaneserestaurant.service.exception.NoSuchResourceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FavoritesServiceImpl implements FavoritesService {
    private final UserRepository userRepository;
    private final DishRepository dishRepository;
    private final DishDtoConverter dishDtoConverter;

    public FavoritesServiceImpl(UserRepository userRepository, DishRepository dishRepository, DishDtoConverter dishDtoConverter) {
        this.userRepository = userRepository;
        this.dishRepository = dishRepository;
        this.dishDtoConverter = dishDtoConverter;
    }

    @Transactional
    @Override
    public void deleteDishFromFavorites(int dishId, int userId) {
        Dish dish = dishRepository.findById(dishId).orElseThrow(NoSuchResourceException::new);
        User user = userRepository.findById(userId).orElseThrow(NoSuchResourceException::new);
        Set<Dish> dishes = user.getFavorites();
        dishes.remove(dish);
        user.setFavorites(dishes);
        userRepository.save(user);
    }

    @Override
    public void addDishToFavorites(int dishId, int userId) {
        Dish dish = dishRepository.findById(dishId).orElseThrow(NoSuchResourceException::new);
        User user = userRepository.findById(userId).orElseThrow(NoSuchResourceException::new);
        Set<Dish> dishes = user.getFavorites();
        dishes.add(dish);
        user.setFavorites(dishes);
        userRepository.save(user);

    }

    @Override
    public List<DishDto> findUserFavorites(int userId) {
        return dishRepository
                .findUserFavorites(userId)
                .stream()
                .map(dishDtoConverter::convertToDto)
                .collect(Collectors.toList());
    }
}
