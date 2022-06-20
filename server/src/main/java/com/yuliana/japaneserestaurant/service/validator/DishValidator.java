package com.yuliana.japaneserestaurant.service.validator;

import com.yuliana.japaneserestaurant.service.dto.DishDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class DishValidator implements Validator {

    private static final int NAME_MIN_LENGTH = 5;
    private static final int NAME_MAX_LENGTH = 45;
    private static final int DISCOUNT_AND_WEIGHT_MIN_VALUE = 1;
    private static final int DISCOUNT_MAX_VALUE = 99;
    private static final int WEIGHT_MAX_VALUE = 10000;
    private static final int DESCRIPTION_MAX_LENGTH = 300;
    private static final String PRICE_REGEX = "[1-9]\\d{0,4}\\.\\d?\\d";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_PICTURE_NAME = "picture_name";
    private static final String FIELD_DESCRIPTION = "description";
    private static final String FIELD_PRICE = "price";
    private static final String FIELD_DISCOUNT_PERCENTS = "discount_percents";
    private static final String FIELD_WEIGHT = "weight";
    private static final String EMPTY_NAME_ERROR = "name_empty";
    private static final String TOO_LONG_OR_TOO_SHORT_NAME_ERROR = "name_too_long_or_too_short";
    private static final String NOT_VALID_DISCOUNT = "discount_not_valid";
    private static final String TOO_LONG_DESCRIPTION_ERROR = "too_long_description";
    private static final String NOT_VALID_PRICE = "price_not_valid";
    private static final String NOT_VALID_WEIGHT = "weight_not_valid";

    @Override
    public boolean supports(Class<?> clazz) {
        return DishDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        DishDto dishDto = (DishDto) target;
        validateName(dishDto.getName(), errors);
        validateDescription(dishDto.getDescription(), errors);
        validateDiscount(dishDto.getDiscountPercents(), errors);
        validatePrice(dishDto.getPrice(), errors);
        validateWeight(dishDto.getWeight(), errors);
    }

    private void validateName(String name, Errors errors) {
        if (name != null) {
            if (name.isBlank()) {
                errors.rejectValue(FIELD_NAME, EMPTY_NAME_ERROR);
            } else if (name.length() < NAME_MIN_LENGTH ||
                    name.length() > NAME_MAX_LENGTH) {
                errors.rejectValue(FIELD_NAME, TOO_LONG_OR_TOO_SHORT_NAME_ERROR);
            }
        }
    }

    private void validateDescription(String description, Errors errors) {
        if (description != null) {
            if (description.length() > DESCRIPTION_MAX_LENGTH) {
                errors.rejectValue(FIELD_DESCRIPTION, TOO_LONG_DESCRIPTION_ERROR);
            }
        }
    }

    private void validateDiscount(short discount, Errors errors) {
        if (discount < DISCOUNT_AND_WEIGHT_MIN_VALUE || discount > DISCOUNT_MAX_VALUE) {
            errors.rejectValue(FIELD_DISCOUNT_PERCENTS, NOT_VALID_DISCOUNT);
        }
    }

    private void validatePrice(BigDecimal price, Errors errors) {
        if (price != null) {
            Pattern pattern = Pattern.compile(PRICE_REGEX);
            Matcher matcher = pattern.matcher(price.toString());
            if (!matcher.matches()) {
                errors.rejectValue(FIELD_PRICE, NOT_VALID_PRICE);
            }
        }
    }

    private void validateWeight(short weight, Errors errors) {
        if (weight < DISCOUNT_AND_WEIGHT_MIN_VALUE || weight > WEIGHT_MAX_VALUE) {
            errors.rejectValue(FIELD_WEIGHT, NOT_VALID_WEIGHT);
        }
    }
}
