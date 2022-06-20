package com.yuliana.japaneserestaurant.service.validator;

import com.yuliana.japaneserestaurant.service.dto.ReviewDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ReviewValidator implements Validator {

    private static final int HEADER_MIN_LENGTH = 5;
    private static final int HEADER_MAX_LENGTH = 50;
    private static final int TEXT_MAX_LENGTH = 500;
    private static final String FIELD_HEADER = "header";
    private static final String FIELD_TEXT = "text";
    private static final String TOO_LONG_OR_TOO_SHORT_HEADER_ERROR = "header_too_long_or_too_short";
    private static final String TOO_LONG_TEXT_ERROR = "text_too_long";



    @Override
    public boolean supports(Class<?> clazz) {
        return ReviewDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ReviewDto reviewDto = (ReviewDto) target;
        validateHeader(reviewDto.getHeader(), errors);
        validateText(reviewDto.getText(), errors);
    }

    private void validateHeader(String header, Errors errors) {
        if(header != null) {
            if(header.length() < HEADER_MIN_LENGTH || header.length() > HEADER_MAX_LENGTH) {
                errors.rejectValue(FIELD_HEADER, TOO_LONG_OR_TOO_SHORT_HEADER_ERROR);
            }
        }
    }

    private void validateText(String text, Errors errors) {
        if(text != null) {
            if(text.length() > TEXT_MAX_LENGTH) {
                errors.rejectValue(FIELD_TEXT, TOO_LONG_TEXT_ERROR);
            }
        }
    }
}
