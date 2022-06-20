package com.yuliana.japaneserestaurant.service.impl;

import com.yuliana.japaneserestaurant.persistence.entity.Order;
import com.yuliana.japaneserestaurant.persistence.repository.OrderRepository;
import com.yuliana.japaneserestaurant.service.OrderService;
import com.yuliana.japaneserestaurant.service.dto.AddressDto;
import com.yuliana.japaneserestaurant.service.dto.OrderDto;
import com.yuliana.japaneserestaurant.service.dto.converter.AddressDtoConverter;
import com.yuliana.japaneserestaurant.service.dto.converter.OrderDtoConverter;
import com.yuliana.japaneserestaurant.service.exception.NoSuchResourceException;
import com.yuliana.japaneserestaurant.service.exception.ResourceAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderDtoConverter orderConverter;
    private final AddressDtoConverter addressConverter;

    public OrderServiceImpl(OrderRepository orderRepository, OrderDtoConverter orderConverter, AddressDtoConverter addressConverter) {
        this.orderRepository = orderRepository;
        this.orderConverter = orderConverter;
        this.addressConverter = addressConverter;
    }

    @Override
    public int addOrder(OrderDto orderDto) {
        if(orderRepository.existsById(orderDto.getOrderId())) {
            throw new ResourceAlreadyExistsException();
        }

        return orderRepository.save(orderConverter.convertToEntity(orderDto)).getOrderId();
    }

    @Override
    public List<OrderDto> findAllOrders() {
        List<Order> orders = (List<Order>) orderRepository.findAll();
        return orders.stream().map(orderConverter::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> findOrdersByUserId(int userId) {
        return orderRepository
                .findByUser_UserId(userId)
                .stream()
                .map(orderConverter::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto findOrderById(int orderId) {
        return orderRepository
                .findById(orderId)
                .map(orderConverter::convertToDto)
                .orElseThrow(NoSuchResourceException::new);
    }

    @Override
    public AddressDto findAddressByOrderId(int orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(NoSuchResourceException::new);
        return addressConverter.convertToDto(order.getAddress());
    }
}
