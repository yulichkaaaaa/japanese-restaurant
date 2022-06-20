package com.yuliana.japaneserestaurant.persistence.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "dishes")
public class Dish {

    public Dish(int dishId, String name, DishCategory category, String pictureName, BigDecimal price, short discountPercents, LocalDateTime dateAdded, String description, short weight) {
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

    public Dish() {
    }

    @Column(name = "dish_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dishId;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "dish_category_id")
    private DishCategory category;

    @Column(name = "picture_name")
    private String pictureName;

    @Column
    private BigDecimal price;

    @Column(name = "discount_percents")
    private short discountPercents;

    @Column(name = "date_added")
    private LocalDateTime dateAdded;

    @Column
    private String description;

    @Column
    private short weight;

    @ManyToMany
    @JoinTable(
            name = "favorites",
            joinColumns = @JoinColumn(name = "dish_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> favorites;

    @OneToMany(mappedBy = "dish")
    private Set<OrderedDishes> orderedDishes;

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

    public DishCategory getCategory() {
        return category;
    }

    public void setCategory(DishCategory category) {
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

    public LocalDateTime getAddedDate() {
        return dateAdded;
    }

    public void setAddedDate(LocalDateTime dateAdded) {
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

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Set<User> getFavorites() {
        return favorites;
    }

    public void setFavorites(Set<User> favorites) {
        this.favorites = favorites;
    }

    public Set<OrderedDishes> getOrderedDishes() {
        return orderedDishes;
    }

    public void setOrderedDishes(Set<OrderedDishes> orderedDishes) {
        this.orderedDishes = orderedDishes;
    }
}
