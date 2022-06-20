package com.yuliana.japaneserestaurant.service;

import com.yuliana.japaneserestaurant.service.dto.AddressDto;
import com.yuliana.japaneserestaurant.service.dto.OrderDto;

import java.util.List;

public interface OrderService {

    /**
     *
     * @param orderDto the {@code OrderDto} object
     * @return id of created order
     */
    int addOrder(OrderDto orderDto);

    /**
     * Find all the orders.
     *
     * @return list of the orders
     */
    List<OrderDto> findAllOrders();

    /**
     * Find all user's orders by it's id.
     *
     * @param userId id of the user
     * @return list of the orders
     */
    List<OrderDto> findOrdersByUserId(int userId);

    /**
     * Find the order by its id.
     *
     * @param orderId id of the order
     * @return the {@code Order} object
=     */
    OrderDto findOrderById(int orderId);

    /**
     * Find the address by order's id.
     *
     * @param orderId id of the order
     * @return the {@code AddressDto} object
     */
    AddressDto findAddressByOrderId(int orderId);

}
