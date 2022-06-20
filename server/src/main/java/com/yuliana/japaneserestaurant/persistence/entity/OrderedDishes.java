package com.yuliana.japaneserestaurant.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "ordered_dishes")
public class OrderedDishes {

    @EmbeddedId
    private OrderedDishesKey id;

    @ManyToOne
    @MapsId("dishId")
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Order order;

    @Column
    private int count;

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
