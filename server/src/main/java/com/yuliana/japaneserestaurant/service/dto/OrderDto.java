package com.yuliana.japaneserestaurant.service.dto;

import java.time.LocalDate;
import java.util.Set;

public class OrderDto {

    private int orderId;
    private LocalDate date;
    private double total;
    private String comment;
    private short paymentTypeId;
    private short receivingTypeId;
    private UserDto user;
    private AddressDto address;
    private Set<DishDto> orderedDishes;

    public OrderDto(int orderId, LocalDate date, double total, String comment, short paymentTypeId, short receivingTypeId, UserDto user, AddressDto address, Set<DishDto> orderedDishes) {
        this.orderId = orderId;
        this.date = date;
        this.total = total;
        this.comment = comment;
        this.paymentTypeId = paymentTypeId;
        this.receivingTypeId = receivingTypeId;
        this.user = user;
        this.address = address;
        this.orderedDishes = orderedDishes;
    }

    public OrderDto() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public short getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(short paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public short getReceivingTypeId() {
        return receivingTypeId;
    }

    public void setReceivingTypeId(short receivingTypeId) {
        this.receivingTypeId = receivingTypeId;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public Set<DishDto> getOrderedDishes() {
        return orderedDishes;
    }

    public void setOrderedDishes(Set<DishDto> orderedDishes) {
        this.orderedDishes = orderedDishes;
    }
}
