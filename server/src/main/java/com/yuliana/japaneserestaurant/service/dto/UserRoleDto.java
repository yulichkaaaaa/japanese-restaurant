package com.yuliana.japaneserestaurant.service.dto;

public class UserRoleDto {
    private short userRoleDto;
    private String name;

    public UserRoleDto(short userRoleDto, String name) {
        this.userRoleDto = userRoleDto;
        this.name = name;
    }

    public UserRoleDto() {
    }

    public short getUserRoleDto() {
        return userRoleDto;
    }

    public void setUserRoleDto(short userRoleDto) {
        this.userRoleDto = userRoleDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
