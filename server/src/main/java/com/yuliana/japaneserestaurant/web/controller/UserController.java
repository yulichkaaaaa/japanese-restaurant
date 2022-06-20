package com.yuliana.japaneserestaurant.web.controller;

import com.yuliana.japaneserestaurant.service.UserService;
import com.yuliana.japaneserestaurant.service.dto.UserDto;
import com.yuliana.japaneserestaurant.service.dto.UserRoleDto;
import com.yuliana.japaneserestaurant.service.dto.UserStatusDto;
import com.yuliana.japaneserestaurant.service.exception.NoSuchUserException;
import com.yuliana.japaneserestaurant.service.exception.NotValidFieldsException;
import com.yuliana.japaneserestaurant.service.exception.UserAlreadyExistsException;
import com.yuliana.japaneserestaurant.service.exception.WrongPasswordException;
import com.yuliana.japaneserestaurant.service.validator.UserValidator;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserValidator userValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(userValidator);
    }

    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public int saveUser(@Valid @RequestBody UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new NotValidFieldsException(bindingResult);
        }

        return userService.registerUser(userDto);
    }

    @PostMapping("/login")
    public UserDto login(@Valid @RequestBody UserDto userDto, BindingResult bindingResult) {
        return userService.loginUser(userDto);
    }


    @GetMapping
    public List<UserDto> findAllUsers(@RequestParam(defaultValue = "") String sortCriteria,
                                      @RequestParam(defaultValue = "asc") String sortDirection,
                                      @RequestParam(defaultValue = "") String email) {
        return userService.findAllUsers(sortCriteria, sortDirection, email);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateUser(@PathVariable int id, @Valid @RequestBody UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new NotValidFieldsException(bindingResult);
        }

        userDto.setUserId(id);
        userService.editUser(userDto);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{id}")
    public void updateUserStatus(@PathVariable int id,
                                 @RequestBody UserStatusDto userStatusDto,
                                 @RequestBody UserRoleDto userRoleDto) {
        if(userStatusDto != null) {
            userService.updateStatus(id, userStatusDto.getUserStatusId());
        } else if (userRoleDto != null) {
            userService.updateRole(id, userRoleDto);
        }
    }

    @ExceptionHandler(WrongPasswordException.class)
    public CustomResponse handleWrongPassword(){
        return new CustomResponse("Wrong password");
    }

    @ExceptionHandler(NoSuchUserException.class)
    public CustomResponse handleNoSuchUser(){
        return new CustomResponse("Account doesn't exist");
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public CustomResponse handleUserAlreadyExists(){
        return new CustomResponse("Account already exists");
    }
}
