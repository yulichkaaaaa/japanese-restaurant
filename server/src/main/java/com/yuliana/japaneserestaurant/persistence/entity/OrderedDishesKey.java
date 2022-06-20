package com.yuliana.japaneserestaurant.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderedDishesKey implements Serializable {

    @Column(name = "dish_id")
    private int dishId;

    @Column(name = "order_id")
    private int orderId;

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderedDishesKey that = (OrderedDishesKey) o;
        return dishId == that.dishId && orderId == that.orderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishId, orderId);
    }
}
