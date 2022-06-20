package com.yuliana.japaneserestaurant.service.impl;

import com.yuliana.japaneserestaurant.persistence.entity.Dish;
import com.yuliana.japaneserestaurant.persistence.repository.DishRepository;
import com.yuliana.japaneserestaurant.service.DishService;
import com.yuliana.japaneserestaurant.service.dto.DishDto;
import com.yuliana.japaneserestaurant.service.dto.converter.DishDtoConverter;
import com.yuliana.japaneserestaurant.service.exception.NoSuchResourceException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DishServiceImpl implements DishService {
    private final DishRepository dishRepository;
    private final DishDtoConverter dishDtoConverter;

    public DishServiceImpl(DishRepository dishRepository, DishDtoConverter dishDtoConverter) {
        this.dishRepository = dishRepository;
        this.dishDtoConverter = dishDtoConverter;
    }

    @Override
    public DishDto findDishById(int dishId) {
        Optional<Dish> dish = dishRepository.findById(dishId);
        return dish.map(dishDtoConverter::convertToDto).orElseThrow(NoSuchResourceException::new);
    }

    @Override
    public List<DishDto> findAllDishes(String sortType, String sortDirection, short dishCategoryId) {
        List<Dish> dishes;
        if (sortType != null && !sortType.isBlank()) {
            if(sortType.equals("popularity")) {
                dishes = dishRepository.findAllDishesSortedByPopularity();
            } else {
                Sort sort = Sort.by(sortDirection.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC, sortType);
                dishes = dishRepository.findAll(sort);
            }
        } else if (dishCategoryId != 0) {
            dishes = dishRepository.findByCategory_DishCategoryId(dishCategoryId);
        } else {
            dishes = dishRepository.findAll();
        }

        return dishes.stream().map(dishDtoConverter::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<DishDto> findDishesByName(String name) {
        List<Dish> dishes = dishRepository.findByName(name);
        return dishes.stream().map(dishDtoConverter::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteDishById(int dishId) {
        if (!dishRepository.existsById(dishId)) {
            throw new NoSuchResourceException();
        }

        dishRepository.deleteById(dishId);
    }

    @Override
    public int addDishToMenu(DishDto dishDto) {
        return dishRepository
                .save(dishDtoConverter.convertToEntity(dishDto))
                .getDishId();
    }

    @Override
    public void editDish(DishDto dishDto) {
        dishRepository.save(dishDtoConverter.convertToEntity(dishDto));
    }
}
