package com.studentsalesmanagementsystem.service;

import com.studentsalesmanagementsystem.dto.PaymentDto;
import com.studentsalesmanagementsystem.entity.Payment;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PaymentService {


    Mono<Payment> savePayment(PaymentDto paymentDto);

    Mono<PaymentDto> updatePayment(PaymentDto paymentDto, String paymentId);

    Flux<PaymentDto> getAllPayments();

    Mono<PaymentDto> getPayment(String paymentId);
}
