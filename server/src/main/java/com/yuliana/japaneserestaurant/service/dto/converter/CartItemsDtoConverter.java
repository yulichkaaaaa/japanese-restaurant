package com.yuliana.japaneserestaurant.service.dto.converter;

import com.yuliana.japaneserestaurant.persistence.entity.CartItems;
import com.yuliana.japaneserestaurant.persistence.entity.Dish;
import com.yuliana.japaneserestaurant.persistence.entity.User;
import com.yuliana.japaneserestaurant.service.dto.CartItemsDto;
import com.yuliana.japaneserestaurant.service.dto.DishCategoryDto;
import com.yuliana.japaneserestaurant.service.dto.DishDto;
import com.yuliana.japaneserestaurant.service.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class CartItemsDtoConverter implements DtoConverter<CartItemsDto, CartItems> {
    @Override
    public CartItemsDto convertToDto(CartItems cartItems) {
        Dish dish = cartItems.getDish();
        DishDto dishDto = new DishDto(dish.getDishId(),
                dish.getName(),
                new DishCategoryDto(dish.getCategory().getDishCategoryId(), dish.getCategory().getName()),
                dish.getPictureName(),
                dish.getPrice(),
                dish.getDiscountPercents(),
                dish.getDateAdded(),
                dish.getDescription(),
                dish.getWeight());
        User user = cartItems.getUser();
        UserDto userDto = new UserDto(user.getUserId(), user.getName(), user.getEmail(), user.getAvatar());
        return new CartItemsDto(dishDto, userDto, cartItems.getCount());
    }

    @Override
    public CartItems convertToEntity(CartItemsDto cartItemsDto) {
        CartItems cartItems = new CartItems();
        cartItems.setCount(cartItemsDto.getCount());
        return cartItems;
    }
}
