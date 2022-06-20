package com.yuliana.japaneserestaurant.service.dto.converter;

public interface DtoConverter<T, U> {
    T convertToDto(U u);
    U convertToEntity(T t);
}
