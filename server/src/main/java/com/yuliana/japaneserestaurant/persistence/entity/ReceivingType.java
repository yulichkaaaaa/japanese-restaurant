package com.yuliana.japaneserestaurant.persistence.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "receiving_types")
public class ReceivingType {

    @Column(name = "receiving_type_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short receivingTypeId;

    @Column
    private String name;

    @OneToMany(mappedBy = "receivingType")
    private Set<Order> orders;

    public short getReceivingTypeId() {
        return receivingTypeId;
    }

    public void setReceivingTypeId(short receivingTypeId) {
        this.receivingTypeId = receivingTypeId;
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
