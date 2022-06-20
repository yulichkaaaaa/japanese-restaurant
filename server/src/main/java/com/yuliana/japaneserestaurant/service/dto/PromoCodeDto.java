package com.yuliana.japaneserestaurant.service.dto;

public class PromoCodeDto {
    private int id;
    private String name;
    private short discountPercents;

    public PromoCodeDto(int id, String name, short discountPercents) {
        this.id = id;
        this.name = name;
        this.discountPercents = discountPercents;
    }

    public PromoCodeDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getDiscountPercents() {
        return discountPercents;
    }

    public void setDiscountPercents(short discountPercents) {
        this.discountPercents = discountPercents;
    }
}
