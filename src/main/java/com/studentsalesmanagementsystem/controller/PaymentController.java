package com.studentsalesmanagementsystem.controller;


import com.studentsalesmanagementsystem.dto.PaymentDto;
import com.studentsalesmanagementsystem.entity.Payment;
import com.studentsalesmanagementsystem.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/pay")
    public Mono<Payment> savePayment(PaymentDto paymentDto) {
        return paymentService.savePayment(paymentDto);
    }

    @GetMapping("/payment{id}")
    public Mono<PaymentDto> getPayment(@PathVariable("id") String paymentId) {
        return paymentService.getPayment(paymentId);
    }

    @GetMapping("/payments")
    public Flux<PaymentDto> getAllPayments() {
        return paymentService.getAllPayments();
    }
    @PutMapping("/update{id}")
    public Mono<PaymentDto> updatePayment(@RequestBody PaymentDto paymentDto,
                                          @PathVariable String paymentId) {
        return paymentService.updatePayment(paymentDto, paymentId);
    }

}
