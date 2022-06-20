package com.yuliana.japaneserestaurant.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "promo_codes")
public class PromoCode {

    @Column(name = "promo_code_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int promoCodeId;

    @Column
    private String name;

    @Column(name = "discount_percents")
    private short discountPercents;

    public PromoCode(int promoCodeId, String name, short discountPercents) {
        this.promoCodeId = promoCodeId;
        this.name = name;
        this.discountPercents = discountPercents;
    }

    public PromoCode() {
    }

    public int getPromoCodeId() {
        return promoCodeId;
    }

    public void setPromoCodeId(int promoCodeId) {
        this.promoCodeId = promoCodeId;
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
