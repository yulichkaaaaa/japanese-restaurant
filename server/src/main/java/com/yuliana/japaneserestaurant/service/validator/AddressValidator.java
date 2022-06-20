package com.yuliana.japaneserestaurant.service.validator;

import com.yuliana.japaneserestaurant.service.dto.AddressDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AddressValidator extends CustomValidator implements Validator{
    private static final String FIELD_CITY = "city";
    private static final String FIELD_STREET = "street";
    private static final String FIELD_HOUSE = "house";
    private static final String FIELD_ENTRANCE = "entrance";
    private static final String FIELD_FLOOR = "floor";
    private static final String FIELD_FLAT = "flat";
    private static final String NOT_VALID_CITY = "city_not_valid";
    private static final String NOT_VALID_STREET = "street_not_valid";
    private static final String NOT_VALID_HOUSE = "house_not_valid";
    private static final String NOT_VALID_ENTRANCE = "entrance_not_valid";
    private static final String NOT_VALID_FLOOR = "floor_not_valid";
    private static final String NOT_VALID_FLAT = "flat_not_valid";
    private static final String EMPTY_CITY_ERROR = "city_empty";
    private static final String EMPTY_STREET_ERROR = "street_empty";
    private static final String EMPTY_HOUSE_ERROR = "house_empty";
    private static final String CITY_REGEX = "[A-Za-zА-Яа-я][a-zа-я]{1,30}";
    private static final String STREET_REGEX = "[A-Za-zА-Яа-я][a-zа-я]{1,30}";
    private static final short MAX_VALUE = 10000;
    private static final short MIN_VALUE = 1;
    private static final short FLOOR_MIN_VALUE = -10;

    @Override
    public boolean supports(Class<?> clazz) {
        return AddressDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AddressDto addressDto = (AddressDto) target;
        validateCity(addressDto.getCity(), errors);
        validateStreet(addressDto.getStreet(), errors);
    }

    private void validateCity(String city, Errors errors) {
        validateStr(city, CITY_REGEX, errors, FIELD_CITY, EMPTY_CITY_ERROR, NOT_VALID_CITY);
    }

    private void validateStreet(String street, Errors errors) {
        validateStr(street, STREET_REGEX, errors, FIELD_STREET, EMPTY_STREET_ERROR, NOT_VALID_STREET);
    }

    private void validateHouse(short house, Errors errors) {
        validateShort(house, MIN_VALUE, MAX_VALUE, errors, FIELD_HOUSE, NOT_VALID_HOUSE);
    }

    private void validateEntrance(short entrance, Errors errors) {
        validateShort(entrance, MIN_VALUE, MAX_VALUE, errors, FIELD_ENTRANCE, NOT_VALID_ENTRANCE);
    }

    private void validateFloor(short floor, Errors errors) {
        validateShort(floor, FLOOR_MIN_VALUE, MAX_VALUE, errors, FIELD_FLOOR, NOT_VALID_FLOOR);
    }

    private void validateFlat(short flat, Errors errors) {
        validateShort(flat, MIN_VALUE, MAX_VALUE, errors, FIELD_FLAT, NOT_VALID_FLAT);
    }
}
