package com.yuliana.japaneserestaurant.service.impl;

import com.yuliana.japaneserestaurant.persistence.entity.User;
import com.yuliana.japaneserestaurant.persistence.entity.UserStatus;
import com.yuliana.japaneserestaurant.persistence.repository.UserRepository;
import com.yuliana.japaneserestaurant.persistence.repository.UserRoleRepository;
import com.yuliana.japaneserestaurant.persistence.repository.UserStatusRepository;
import com.yuliana.japaneserestaurant.service.UserService;
import com.yuliana.japaneserestaurant.service.dto.UserDto;
import com.yuliana.japaneserestaurant.service.dto.UserRoleDto;
import com.yuliana.japaneserestaurant.service.dto.converter.UserDtoConverter;
import com.yuliana.japaneserestaurant.service.exception.NoSuchResourceException;
import com.yuliana.japaneserestaurant.service.exception.NoSuchUserException;
import com.yuliana.japaneserestaurant.service.exception.UserAlreadyExistsException;
import com.yuliana.japaneserestaurant.service.exception.WrongPasswordException;
import org.springframework.data.domain.Sort;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserDtoConverter userConverter;
    private final UserStatusRepository userStatusRepository;
    private final UserRoleRepository userRoleRepository;

    public UserServiceImpl(UserRepository userRepository, UserDtoConverter userConverter, UserStatusRepository userStatusRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
        this.userStatusRepository = userStatusRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserDto loginUser(UserDto userDto) {
        if(!userRepository.existsByEmail(userDto.getEmail())) {
            throw new NoSuchUserException();
        }

        User user = userRepository.findByEmailAndPassword(userDto.getEmail(), userDto.getPassword());
        if (user == null) {
            throw new WrongPasswordException();
        }

        return userConverter.convertToDto(user);
    }

    @Override
    public int registerUser(UserDto userDto) {
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new UserAlreadyExistsException();
        }

        User user = userConverter.convertToEntity(userDto);
        user.setRole(userRoleRepository.findById((short) 1).get());
        user.setStatus(userStatusRepository.findById((short) 1).get());
        return userRepository.save(user).getUserId();
    }

    @Override
    public List<UserDto> findAllUsers(String sortType, String sortDirection, String email) {
        List<User> users;
        if (sortType != null && !sortType.isBlank()) {
            Sort sort = Sort.by(sortDirection.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC, sortType);
            users = (List<User>) userRepository.findAll(sort);
        } else if (email != null && !email.isBlank()) {
            users = userRepository.findByEmailLike(email);
        } else {
            users = (List<User>) userRepository.findAll();
        }

        return users.stream().map(userConverter::convertToDto).collect(Collectors.toList());
    }


    @Override
    public void editUser(UserDto userDto) {

    }

    @Transactional
    @Override
    public void updateStatus(int userId, short statusId) {
        User user = userRepository.findById(userId).orElseThrow(NoSuchResourceException::new);
        UserStatus userStatus = userStatusRepository.findById(statusId).orElseThrow(NoSuchResourceException::new);
        user.setStatus(userStatus);
        userRepository.save(user);
    }

    @Override
    public void updateRole(int userId, UserRoleDto userRoleDto) {
        /*User user = userRepository.findById(userId).orElseThrow(NoSuchResourceException::new);
        UserStatus userStatus = userStatusRepository.findById(statusId).orElseThrow(NoSuchResourceException::new);
        user.setStatus(userStatus);
        userRepository.save(user);*/
    }
}
