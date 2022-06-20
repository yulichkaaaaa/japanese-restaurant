package com.yuliana.japaneserestaurant.web.controller;

import com.yuliana.japaneserestaurant.service.CartItemsService;
import com.yuliana.japaneserestaurant.service.dto.CartItemsDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart_items")
public class CartItemsController {
    private final CartItemsService cartItemsService;

    public CartItemsController(CartItemsService cartItemsService) {
        this.cartItemsService = cartItemsService;
    }

    @PostMapping("/{userId}/{dishId}")
    public void createCartItem(@PathVariable int userId, @PathVariable int dishId) {
        cartItemsService.addItem(userId, dishId);
    }

    @DeleteMapping("/{userId}/{dishId}")
    public void deleteCartItem(@PathVariable int userId, @PathVariable int dishId, @RequestParam(defaultValue = "1") int count) {
        cartItemsService.deleteItem(userId, dishId, count);
    }

    @GetMapping("/users/{userId}")
    public List<CartItemsDto> findUserCartItems(@PathVariable int userId) {
       return cartItemsService.findUserItems(userId);
    }
}
