package com.yuliana.japaneserestaurant.service.validator;

import com.yuliana.japaneserestaurant.service.dto.PromoCodeDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PromoCodeValidator implements Validator {

    private static final int NAME_MIN_LENGTH = 5;
    private static final int NAME_MAX_LENGTH = 45;
    private static final int DISCOUNT_MIN_VALUE = 1;
    private static final int DISCOUNT_MAX_VALUE = 99;
    private static final String FIELD_NAME = "name";
    private static final String FIELD_DISCOUNT = "discount";
    private static final String EMPTY_NAME_ERROR = "name_empty";
    private static final String TOO_LONG_OR_TOO_SHORT_NAME_ERROR = "name_too_long_or_too_short";
    private static final String NOT_VALID_DISCOUNT = "discount_not_valid";

    @Override
    public boolean supports(Class<?> clazz) {
        return PromoCodeDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PromoCodeDto promoCodeDto = (PromoCodeDto) target;
        validateName(promoCodeDto.getName(), errors);
        validateDiscount(promoCodeDto.getDiscountPercents(), errors);
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

    private void validateDiscount(short discount, Errors errors) {
        if (discount < DISCOUNT_MIN_VALUE || discount > DISCOUNT_MAX_VALUE) {
            errors.rejectValue(FIELD_DISCOUNT, NOT_VALID_DISCOUNT);
        }
    }
}
