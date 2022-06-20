package com.yuliana.japaneserestaurant.service.dto;

import java.util.Objects;

public class AddressDto {
    private int addressId;
    private String city;
    private String street;
    private short house;
    private short entrance;
    private short floor;
    private short flat;

    public AddressDto(int addressId, String city, String street, short house, short entrance, short floor, short flat) {
        this.addressId = addressId;
        this.city = city;
        this.street = street;
        this.house = house;
        this.entrance = entrance;
        this.floor = floor;
        this.flat = flat;
    }

    public AddressDto() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDto that = (AddressDto) o;
        return addressId == that.addressId && house == that.house && entrance == that.entrance && floor == that.floor && flat == that.flat && Objects.equals(city, that.city) && Objects.equals(street, that.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, city, street, house, entrance, floor, flat);
    }
}
