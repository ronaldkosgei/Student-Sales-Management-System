package com.studentsalesmanagementsystem.mapper;

import com.studentsalesmanagementsystem.dto.OrderDto;
import com.studentsalesmanagementsystem.entity.Order;

public class OrderMapper {

    public static OrderDto mapToOrderDto(Order order){
        return new OrderDto(
                order.getOrderId(),
                order.getItems(),
                order.getQuantity(),
                order.getPrice(),
                order.getOrderStatus(),
                order.getOrderDate(),
                order.getPaymentInformation()
        );
    }

    public static Order mapToOrder(OrderDto orderDto){
        return new Order(
                orderDto.getOrderId(),
                orderDto.getItems(),
                orderDto.getQuantity(),
                orderDto.getPrice(),
                orderDto.getOrderStatus(),
                orderDto.getOrderDate(),
                orderDto.getPaymentInformation()
        );
    }
}
