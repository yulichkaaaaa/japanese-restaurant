package com.yuliana.japaneserestaurant.service.validator;

import org.springframework.validation.Errors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class CustomValidator {
    protected void validateStr(String str, String regex, Errors errors, String field, String emptyError, String regexError) {
        if (str != null) {
            if (str.isBlank()) {
                errors.rejectValue(field, emptyError);
            } else {
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(str);
                if (!matcher.matches()) {
                    errors.rejectValue(field, regexError);
                }
            }
        }
    }

    protected void validateShort(short sh, short min, short max, Errors errors, String field, String error) {
        if(sh < min || sh > max) {
            errors.rejectValue(field, error);
        }
    }
}
