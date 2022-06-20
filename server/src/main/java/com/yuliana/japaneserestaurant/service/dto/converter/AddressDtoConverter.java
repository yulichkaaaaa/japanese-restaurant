package com.yuliana.japaneserestaurant.service.dto.converter;

import com.yuliana.japaneserestaurant.persistence.entity.Address;
import com.yuliana.japaneserestaurant.service.dto.AddressDto;
import org.springframework.stereotype.Component;

@Component
public class AddressDtoConverter implements DtoConverter<AddressDto, Address> {
    @Override
    public AddressDto convertToDto(Address address) {
        return new AddressDto(
                address.getAddressId(),
                address.getCity(),
                address.getStreet(),
                address.getHouse(),
                address.getEntrance(),
                address.getFloor(),
                address.getFlat());
    }

    @Override
    public Address convertToEntity(AddressDto addressDto) {
        return new Address(
                addressDto.getAddressId(),
                addressDto.getCity(),
                addressDto.getStreet(),
                addressDto.getHouse(),
                addressDto.getEntrance(),
                addressDto.getFloor(),
                addressDto.getFlat());
    }
}
