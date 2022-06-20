package com.yuliana.japaneserestaurant.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CartItemsKey implements Serializable {

    @Column(name = "dish_id")
    private int dishId;

    @Column(name = "user_id")
    private int userId;

    public CartItemsKey(int dishId, int userId) {
        this.dishId = dishId;
        this.userId = userId;
    }

    public CartItemsKey() {
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItemsKey that = (CartItemsKey) o;
        return dishId == that.dishId && userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishId, userId);
    }
}
