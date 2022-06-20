package com.yuliana.japaneserestaurant.web.controller;

import com.yuliana.japaneserestaurant.service.OrderService;
import com.yuliana.japaneserestaurant.service.dto.OrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void makeOrder(@RequestBody OrderDto orderDto) {
        orderService.addOrder(orderDto);
    }

    @GetMapping("/users/{userId}")
    public List<OrderDto> findUserOrders(@PathVariable int userId) {
        return orderService.findOrdersByUserId(userId);
    }
}
