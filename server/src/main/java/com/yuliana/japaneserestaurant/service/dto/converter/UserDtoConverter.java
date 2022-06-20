package com.yuliana.japaneserestaurant.service.dto.converter;

import com.yuliana.japaneserestaurant.persistence.entity.User;
import com.yuliana.japaneserestaurant.persistence.entity.UserRole;
import com.yuliana.japaneserestaurant.persistence.entity.UserStatus;
import com.yuliana.japaneserestaurant.service.dto.UserDto;
import com.yuliana.japaneserestaurant.service.dto.UserRoleDto;
import com.yuliana.japaneserestaurant.service.dto.UserStatusDto;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter implements DtoConverter<UserDto, User> {
    @Override
    public UserDto convertToDto(User user) {
        UserRole userRole = user.getRole();
        UserRoleDto userRoleDto = new UserRoleDto(userRole.getUserRoleId(), userRole.getName());
        UserStatus userStatus = user.getStatus();
        UserStatusDto userStatusDto = new UserStatusDto(userStatus.getUserStatusId(), user.getName());
        return new UserDto(
                user.getUserId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                userRoleDto, userStatusDto,
                user.getAvatar(),
                null,
                null,
                null);
    }

    @Override
    public User convertToEntity(UserDto userDto) {
        return new User(userDto.getName(), userDto.getEmail(),userDto.getPassword());
    }
}
