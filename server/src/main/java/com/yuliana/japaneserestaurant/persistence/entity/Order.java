package com.yuliana.japaneserestaurant.persistence.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Table(name = "orders")
@Entity
public class Order {

    @Column(name = "order_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @Column
    private LocalDate date;

    @Column
    private double total;

    @Column
    private String comment;

    @ManyToOne
    @JoinColumn(name = "payment_type_id")
    private PaymentType paymentType;

    @ManyToOne
    @JoinColumn(name = "receiving_type_id")
    private ReceivingType receivingType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "order")
    private Set<OrderedDishes> orderedDishes;

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

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public ReceivingType getReceivingType() {
        return receivingType;
    }

    public void setReceivingType(ReceivingType receivingType) {
        this.receivingType = receivingType;
    }

    public Set<OrderedDishes> getOrderedDishes() {
        return orderedDishes;
    }

    public void setOrderedDishes(Set<OrderedDishes> orderedDishes) {
        this.orderedDishes = orderedDishes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
