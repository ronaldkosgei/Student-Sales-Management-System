package com.studentsalesmanagementsystem.service;


import com.studentsalesmanagementsystem.dto.OrderDto;
import com.studentsalesmanagementsystem.entity.Order;
import com.studentsalesmanagementsystem.mapper.OrderMapper;
import com.studentsalesmanagementsystem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Mono<Order> saveOrder(OrderDto orderDto) {
        Order order = OrderMapper.mapToOrder(orderDto);
        Mono<Order> savedOrder = orderRepository.save(order);
        return savedOrder.map(orderEntity -> OrderMapper.mapToOrder(orderDto));
    }


    @Override
    public Mono<OrderDto> getOrder(String orderId) {
        Mono<Order> orderMono = orderRepository.findById(orderId);
        return orderMono.map(order -> OrderMapper.mapToOrderDto(order));
    }

    @Override
    public Mono<OrderDto> getPaymentInformation(String orderId) {
        Mono<Order> orderMono = orderRepository.findById(orderId);
        return orderMono.map(order -> OrderMapper.mapToOrderDto(order));
    }

    @Override
    public Flux<OrderDto> getAllOrders() {
        Flux<Order> orderFlux = orderRepository.findAll();
        return orderFlux
                .map((order) -> OrderMapper.mapToOrderDto(order))
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<OrderDto> updateOrder(OrderDto orderDto, String orderId) {
        Mono<Order> orderMono = orderRepository.findById(orderId);
        return orderMono.flatMap((existingOrder) -> {
            existingOrder.setItems(orderDto.getItems());
            existingOrder.setQuantity(orderDto.getQuantity());
            existingOrder.setPrice(orderDto.getPrice());
            existingOrder.setOrderStatus(orderDto.getOrderStatus());
            existingOrder.setOrderDate(orderDto.getOrderDate());
            existingOrder.setPaymentInformation(orderDto.getPaymentInformation());
            return orderRepository.save(existingOrder);
        }).map(order -> OrderMapper.mapToOrderDto(order));
    }

    @Override
    public Mono<Void> deleteOrder(String orderId) {
        Mono<Order> orderMono = orderRepository.findById(orderId);
        return orderMono.flatMap((order) -> orderRepository.delete(order));
    }

    @Override
    public Mono<OrderDto> getOrderDate(String orderId) {
        Mono<Order> orderMono = orderRepository.findById(orderId);
            return orderMono.map(order -> OrderMapper.mapToOrderDto(order));
    }
}
