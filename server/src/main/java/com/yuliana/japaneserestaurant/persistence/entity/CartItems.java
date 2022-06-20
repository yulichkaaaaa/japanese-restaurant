package com.yuliana.japaneserestaurant.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "cart_items")
public class CartItems {
    @EmbeddedId
    private CartItemsKey id;

    @ManyToOne
    @MapsId("dishId")
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private int count;

    public CartItemsKey getId() {
        return id;
    }

    public void setId(CartItemsKey id) {
        this.id = id;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
