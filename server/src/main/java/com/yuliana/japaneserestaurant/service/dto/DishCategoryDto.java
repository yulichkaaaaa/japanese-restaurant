package com.yuliana.japaneserestaurant.service.dto;

public class DishCategoryDto {

    private short dishCategoryId;
    private String name;

    public DishCategoryDto(short dishCategoryId, String name) {
        this.dishCategoryId = dishCategoryId;
        this.name = name;
    }

    public DishCategoryDto() {
    }

    public short getDishCategoryId() {
        return dishCategoryId;
    }

    public void setDishCategoryId(short dishCategoryId) {
        this.dishCategoryId = dishCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
