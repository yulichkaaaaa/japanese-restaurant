package com.yuliana.japaneserestaurant.service;

import com.yuliana.japaneserestaurant.service.dto.AddressDto;

import java.util.List;

public interface AddressService {

    /**
     * Add new address. Validate the fields.
     *
     * @param addressDto the {@code AddressDto} object.
     * @return id of the added address
     */
    int addAddress(AddressDto addressDto);

    /**
     * Find address by its id.
     *
     * @param addressId id of the address
     * @return the {@code Address} object
     */
    AddressDto findAddressById(int addressId);

    /**
     * Update the address by its id.
     *
     * @param addressDto the {@code AddressDto} object.
     */
    void updateAddress(AddressDto addressDto);

    /**
     * Find all addresses where cafes are located.
     *
     * @return list of the {@code AddressDto} objects
     */
    List<AddressDto> findCafeAddresses();

    /**
     * Find address of the user by user's id.
     *
     * @param userId id of the user
     * @return the {@code Address} object
     */
    AddressDto findUserAddress(int userId);

    /**
     * Add address to user by address's and user's ids.
     *
     * @param addressId id of the address
     * @param userId if of the user
     */
    void addUserAddress(int addressId, int userId);
}
