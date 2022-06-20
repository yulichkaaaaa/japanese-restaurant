package com.yuliana.japaneserestaurant.service.dto;

import com.yuliana.japaneserestaurant.service.dto.DishDto;
import com.yuliana.japaneserestaurant.service.dto.UserDto;

public class CartItemsDto {
    private DishDto dishDto;
    private UserDto userDto;
    private int count;

    public CartItemsDto() {
    }

    public CartItemsDto(DishDto dishDto, UserDto userDto, int count) {
        this.dishDto = dishDto;
        this.userDto = userDto;
        this.count = count;
    }

    public DishDto getDishDto() {
        return dishDto;
    }

    public void setDishDto(DishDto dishDto) {
        this.dishDto = dishDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
