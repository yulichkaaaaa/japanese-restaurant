package com.yuliana.japaneserestaurant.persistence.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    @Column
    private String city;

    @Column
    private String street;

    @Column
    private short house;

    @Column
    private short entrance;

    @Column
    private short floor;

    @Column
    private short flat;

    @OneToOne(mappedBy = "address")
    private User user;

    @OneToOne(mappedBy = "address")
    private Cafe cafe;

    @OneToMany(mappedBy = "address")
    private Set<Order> orders;

    public Address(int addressId, String city, String street, short house, short entrance, short floor, short flat) {
        this.addressId = addressId;
        this.city = city;
        this.street = street;
        this.house = house;
        this.entrance = entrance;
        this.floor = floor;
        this.flat = flat;
    }

    public Address() {
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public short getHouse() {
        return house;
    }

    public void setHouse(short house) {
        this.house = house;
    }

    public short getEntrance() {
        return entrance;
    }

    public void setEntrance(short entrance) {
        this.entrance = entrance;
    }

    public short getFloor() {
        return floor;
    }

    public void setFloor(short floor) {
        this.floor = floor;
    }

    public short getFlat() {
        return flat;
    }

    public void setFlat(short flat) {
        this.flat = flat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cafe getCafe() {
        return cafe;
    }

    public void setCafe(Cafe cafe) {
        this.cafe = cafe;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
