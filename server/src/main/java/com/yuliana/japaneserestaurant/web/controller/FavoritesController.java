package com.yuliana.japaneserestaurant.web.controller;

import com.yuliana.japaneserestaurant.service.FavoritesService;
import com.yuliana.japaneserestaurant.service.dto.DishDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorites")
public class FavoritesController {

    private final FavoritesService favoritesService;

    public FavoritesController(FavoritesService favoritesService) {
        this.favoritesService = favoritesService;
    }

    @GetMapping("/users/{userId}")
    public List<DishDto> findByUserId(@PathVariable int userId) {
        return favoritesService.findUserFavorites(userId);
    }

    @PostMapping("/users/{userId}/dishes/{dishId}")
    public void addToFavorites(@PathVariable int userId, @PathVariable int dishId) {
        favoritesService.addDishToFavorites(dishId, userId);
    }

    @DeleteMapping("/users/{userId}/dishes/{dishId}")
    public void deleteFromFavorites(@PathVariable int userId, @PathVariable int dishId) {
        favoritesService.deleteDishFromFavorites(dishId, userId);
    }
}
