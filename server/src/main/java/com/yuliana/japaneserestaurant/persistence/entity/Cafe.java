package com.yuliana.japaneserestaurant.persistence.entity;

import javax.persistence.*;
import java.time.LocalTime;


@Entity
@Table(name = "cafes")
public class Cafe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cafe_id")
    private short cafeId;

    @Column
    private String phone;

    @Column(name = "open_time")
    private LocalTime openTime;

    @Column(name = "close_time")
    private LocalTime closeTime;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(mappedBy = "address")
    private Cafe cafe;

    public short getCafeId() {
        return cafeId;
    }

    public void setCafeId(short cafeId) {
        this.cafeId = cafeId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public void setOpenTime(LocalTime openTime) {
        this.openTime = openTime;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(LocalTime closeTime) {
        this.closeTime = closeTime;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Cafe getCafe() {
        return cafe;
    }

    public void setCafe(Cafe cafe) {
        this.cafe = cafe;
    }
}
