package com.studentsalesmanagementsystem.service;

import com.studentsalesmanagementsystem.dto.OrderDto;
import com.studentsalesmanagementsystem.entity.Order;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderService {


    Mono<Order> saveOrder(OrderDto orderDto);

    Mono<OrderDto> getOrder(String orderId);

    Mono<OrderDto>  getPaymentInformation(String orderId);

    Flux<OrderDto> getAllOrders();

    Mono<OrderDto> updateOrder(OrderDto orderDto, String orderId);

    Mono<Void> deleteOrder(String orderId);

    Mono<OrderDto> getOrderDate(String orderId);
}
