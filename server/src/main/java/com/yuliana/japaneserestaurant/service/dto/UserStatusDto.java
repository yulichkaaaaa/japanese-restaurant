package com.yuliana.japaneserestaurant.service.dto;

public class UserStatusDto {

    private short userStatusId;
    private String name;

    public UserStatusDto(short userStatusId, String name) {
        this.userStatusId = userStatusId;
        this.name = name;
    }

    public UserStatusDto() {
    }

    public short getUserStatusId() {
        return userStatusId;
    }

    public void setUserStatusId(short userStatusId) {
        this.userStatusId = userStatusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
