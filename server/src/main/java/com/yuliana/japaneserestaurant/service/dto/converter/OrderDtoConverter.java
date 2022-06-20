package com.yuliana.japaneserestaurant.service.dto.converter;

import com.yuliana.japaneserestaurant.persistence.entity.Order;
import com.yuliana.japaneserestaurant.service.dto.OrderDto;
import org.springframework.stereotype.Component;

@Component
public class OrderDtoConverter implements DtoConverter<OrderDto, Order> {
    @Override
    public OrderDto convertToDto(Order order) {
        return null;
    }

    @Override
    public Order convertToEntity(OrderDto orderDto) {
        return null;
    }
}
