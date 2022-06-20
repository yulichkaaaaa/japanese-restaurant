package com.yuliana.japaneserestaurant.persistence.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "payment_types")
public class PaymentType {

    @Column(name = "payment_type_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short paymentTypeId;

    @Column
    private String name;

    @OneToMany(mappedBy = "paymentType")
    private Set<Order> orders;

    public short getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(short paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
