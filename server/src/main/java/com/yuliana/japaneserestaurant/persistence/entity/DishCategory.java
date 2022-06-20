package com.yuliana.japaneserestaurant.persistence.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "dish_categories")
public class DishCategory {

    public DishCategory() {
    }

    public DishCategory(short dishCategoryId, String name) {
        this.dishCategoryId = dishCategoryId;
        this.name = name;
    }

    @Column(name = "dish_category_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short dishCategoryId;

    @Column
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Dish> dishes;

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

    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }
}
