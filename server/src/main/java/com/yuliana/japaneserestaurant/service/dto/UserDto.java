package com.yuliana.japaneserestaurant.service.dto;

import com.yuliana.japaneserestaurant.persistence.entity.*;

import java.util.Set;

public class UserDto {
    private int userId;
    private String name;
    private String email;
    private String password;
    private UserRoleDto role;
    private UserStatusDto status;
    private String avatar;
    private Set<DishDto> favorites;
    private AddressDto address;
    private Set<OrderDto> orders;

    public UserDto(int userId, String name, String email, String password, UserRoleDto role, UserStatusDto status, String avatar, Set<DishDto> favorites, AddressDto address, Set<OrderDto> orders) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = status;
        this.avatar = avatar;
        this.favorites = favorites;
        this.address = address;
        this.orders = orders;
    }

    public UserDto(int userId, String name, String email, String avatar) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.avatar = avatar;
    }

    public UserDto() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public UserRoleDto getRole() {
        return role;
    }

    public void setRole(UserRoleDto role) {
        this.role = role;
    }

    public UserStatusDto getStatus() {
        return status;
    }

    public void setStatus(UserStatusDto status) {
        this.status = status;
    }

    public void setFavorites(Set<DishDto> favorites) {
        this.favorites = favorites;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public void setOrders(Set<OrderDto> orders) {
        this.orders = orders;
    }

    public Set<DishDto> getFavorites() {
        return favorites;
    }

    public AddressDto getAddress() {
        return address;
    }

    public Set<OrderDto> getOrders() {
        return orders;
    }
}
