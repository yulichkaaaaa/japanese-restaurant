package com.yuliana.japaneserestaurant.service.impl;

import com.yuliana.japaneserestaurant.persistence.entity.Address;
import com.yuliana.japaneserestaurant.persistence.entity.User;
import com.yuliana.japaneserestaurant.persistence.repository.AddressRepository;
import com.yuliana.japaneserestaurant.persistence.repository.UserRepository;
import com.yuliana.japaneserestaurant.service.AddressService;
import com.yuliana.japaneserestaurant.service.dto.AddressDto;
import com.yuliana.japaneserestaurant.service.dto.converter.AddressDtoConverter;
import com.yuliana.japaneserestaurant.service.exception.NoSuchResourceException;
import com.yuliana.japaneserestaurant.service.exception.ResourceAlreadyExistsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressDtoConverter addressConverter;
    private final UserRepository userRepository;

    public AddressServiceImpl(AddressRepository addressRepository, AddressDtoConverter addressConverter, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.addressConverter = addressConverter;
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public int addAddress(AddressDto addressDto) {
        if (addressRepository.existsById(addressDto.getAddressId())) {
            throw new ResourceAlreadyExistsException();
        }

        return addressRepository
                .save(addressConverter.convertToEntity(addressDto))
                .getAddressId();
    }

    @Override
    public AddressDto findAddressById(int addressId) {
        Optional<Address> address = addressRepository.findById(addressId);
        return address.map(addressConverter::convertToDto).orElseThrow(NoSuchResourceException::new);
    }

    @Transactional
    @Override
    public void updateAddress(AddressDto addressDto) {
        if (!addressRepository.existsById(addressDto.getAddressId())) {
            throw new NoSuchResourceException();
        }

        addressRepository.save(addressConverter.convertToEntity(addressDto));
    }

    @Override
    public List<AddressDto> findCafeAddresses() {
        return addressRepository
                .findCafeAddresses()
                .stream()
                .map(addressConverter::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AddressDto findUserAddress(int userId) {
        if(!userRepository.existsById(userId)) {
            throw new NoSuchResourceException();
        }

        return addressRepository
                .findByUser_UserId(userId)
                .map(addressConverter::convertToDto)
                .orElseThrow(NoSuchResourceException::new);
    }

    @Transactional
    @Override
    public void addUserAddress(int addressId, int userId) {
        User user = userRepository.findById(userId).orElseThrow(NoSuchResourceException::new);
        Address address = addressRepository.findById(addressId).orElseThrow(NoSuchResourceException::new);
        user.setAddress(address);
        userRepository.save(user);
    }
}
