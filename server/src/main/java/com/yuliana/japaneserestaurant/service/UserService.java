package com.yuliana.japaneserestaurant.service;

import com.yuliana.japaneserestaurant.service.dto.UserDto;
import com.yuliana.japaneserestaurant.service.dto.UserRoleDto;

import java.util.List;

public interface UserService {
    /**
     * Login the user by email and password hash. Validate the fields and make a hash from the password string.
     *
     * @param userDto {@code UserDto} object
     * @return the {@code User} object
     */
    UserDto loginUser(UserDto userDto);

    /**
     * Register user. Validate the fields and make a hash from the password string.
     *
     * @param userDto {@code UserDto} object
     */
    int registerUser(UserDto userDto);

    /**
     * Find users by params.
     *
     * @param sortType sort criteria
     * @param sortDirection sort direction
     * @param email email
     * @return list of users
     */
    List<UserDto> findAllUsers(String sortType, String sortDirection, String email);

    /**
     * Edit user's information. Validate the fields.
     *
     * @param userDto the {@code UserDto} object
     */
    void editUser(UserDto userDto);


    /**
     * Update status of the user to one of this values: online, offline or blocked.
     *
     * @param userId id of the user
     * @param statusId id of the user status
\     */
    void updateStatus(int userId, short statusId);

    /**
     * Update role of the user to one of this values: admin or user.
     *
     * @param userId id of the user
     * @param userRoleDto {@code UserRoleDto}
     */
    void updateRole(int userId, UserRoleDto userRoleDto);
}
