package com.yuliana.japaneserestaurant.web.controller;

import com.yuliana.japaneserestaurant.service.DishService;
import com.yuliana.japaneserestaurant.service.dto.DishCategoryDto;
import com.yuliana.japaneserestaurant.service.dto.DishDto;
import com.yuliana.japaneserestaurant.service.exception.NotValidFieldsException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/dishes")
public class DishController {

    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/{id}")
    public DishDto findById(@PathVariable int id) {
        return dishService.findDishById(id);
    }

    @GetMapping()
    public List<DishDto> findAll(@RequestParam(defaultValue = "") String sortCriteria,
                                 @RequestParam(defaultValue = "asc") String sortDirection,
                                 @RequestParam(defaultValue = "0") short dishCategoryId) {
        return dishService.findAllDishes(sortCriteria, sortDirection, dishCategoryId);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        dishService.deleteDishById(id);
    }

    @PostMapping
    public void create(@RequestBody @Valid DishDto dishDto,
                       BindingResult bindingResult,
                       @RequestParam("image") MultipartFile multipartFile) {
        if(bindingResult.hasErrors()) {
            throw new NotValidFieldsException(bindingResult);
        }


        dishService.addDishToMenu(dishDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody @Valid DishDto dishDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            throw new NotValidFieldsException(bindingResult);
        }

        dishDto.setDishId(id);
        dishService.editDish(dishDto);
    }
}
