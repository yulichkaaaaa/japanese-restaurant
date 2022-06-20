package com.yuliana.japaneserestaurant.service.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DishDto {
    private int dishId;
    private String name;
    private DishCategoryDto category;
    private String pictureName;
    private BigDecimal price;
    private short discountPercents;
    private LocalDateTime dateAdded;
    private String description;
    private short weight;

    public DishDto(int dishId, String name, DishCategoryDto category, String pictureName, BigDecimal price, short discountPercents, LocalDateTime dateAdded, String description, short weight) {
        this.dishId = dishId;
        this.name = name;
        this.category = category;
        this.pictureName = pictureName;
        this.price = price;
        this.discountPercents = discountPercents;
        this.dateAdded = dateAdded;
        this.description = description;
        this.weight = weight;
    }

    public DishDto() {
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DishCategoryDto getCategory() {
        return category;
    }

    public void setCategory(DishCategoryDto category) {
        this.category = category;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public short getDiscountPercents() {
        return discountPercents;
    }

    public void setDiscountPercents(short discountPercents) {
        this.discountPercents = discountPercents;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public short getWeight() {
        return weight;
    }

    public void setWeight(short weight) {
        this.weight = weight;
    }
}
