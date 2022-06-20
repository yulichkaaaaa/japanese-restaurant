package com.yuliana.japaneserestaurant.service.validator;

import com.yuliana.japaneserestaurant.service.dto.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator extends CustomValidator implements Validator{

    private static final String EMAIL_REGEX = "[A-Za-z0-9_.]{2,22}@[a-z]{2,10}\\.[a-z]{2,6}";
    private static final String PASSWORD_REGEX = "[A-Za-z0-9_]{5,20}";
    private static final String NAME_REGEX = "[A-Za-zА-Яа-яёЁ]{3,25}";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_EMAIL = "email";
    private static final String FIELD_PASSWORD = "password";
    private static final String NOT_VALID_NAME = "name_not_valid";
    private static final String NOT_VALID_EMAIL = "email_not_valid";
    private static final String NOT_VALID_PASSWORD = "password_not_valid";
    private static final String EMPTY_NAME_ERROR = "name_empty";
    private static final String EMPTY_EMAIL_ERROR = "email_empty";
    private static final String EMPTY_PASSWORD_ERROR = "password_empty";


    @Override
    public boolean supports(Class<?> clazz) {
        return UserDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        validateName(userDto.getName(), errors);
        validateEmail(userDto.getEmail(), errors);
        validatePassword(userDto.getPassword(), errors);
    }

    private void validateName(String name, Errors errors) {
        validateStr(name, NAME_REGEX, errors, FIELD_NAME, EMPTY_NAME_ERROR, NOT_VALID_NAME);
    }

    private void validateEmail(String email, Errors errors) {
        validateStr(email, EMAIL_REGEX, errors, FIELD_EMAIL, EMPTY_EMAIL_ERROR, NOT_VALID_EMAIL);
    }

    private void validatePassword(String password, Errors errors) {
        validateStr(password, PASSWORD_REGEX, errors, FIELD_PASSWORD, EMPTY_PASSWORD_ERROR, NOT_VALID_PASSWORD);
    }
}
