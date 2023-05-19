package com.studentsalesmanagementsystem.controller;


import com.studentsalesmanagementsystem.dto.OrderDto;
import com.studentsalesmanagementsystem.entity.Order;
import com.studentsalesmanagementsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("/save")
    public Mono<Order> saveOrder(@RequestBody OrderDto orderDto){
        return orderService.saveOrder(orderDto);

    }
    @GetMapping("/get/{id}")
    public Mono<OrderDto> getOrder(@PathVariable("orderId") String orderId){
        return orderService.getOrder(orderId);
    }

    @GetMapping("/PaymentInformation/{id}")
    public Mono<OrderDto> getPaymentInformation(@PathVariable("orderId") String orderId){
        return orderService.getPaymentInformation(orderId);
    }

    @GetMapping("/orderDate")
    public Mono<OrderDto> getOrderDate(@PathVariable("orderId") String orderId){
        return orderService.getOrderDate(orderId);
    }

    @GetMapping("/getAll")
    public Flux<OrderDto> getAllOrders(){
        return orderService.getAllOrders();
    }

    @PutMapping("/update/{id}")
    public Mono<OrderDto> updateOrder(@RequestBody OrderDto orderDto,
                                      @PathVariable("orderId") String orderId){
        return orderService.updateOrder(orderDto, orderId);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteOrder(@PathVariable("orderId") String orderId){
        return orderService.deleteOrder(orderId);
    }


}
