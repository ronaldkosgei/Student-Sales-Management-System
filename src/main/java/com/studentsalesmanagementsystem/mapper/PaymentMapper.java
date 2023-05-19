package com.studentsalesmanagementsystem.mapper;

import com.studentsalesmanagementsystem.dto.PaymentDto;
import com.studentsalesmanagementsystem.entity.Payment;

public class PaymentMapper {

    public  static PaymentDto mapToPaymentDto(Payment payment){
        return new PaymentDto(
            payment.getPaymentId(),
            payment.getAmount(),
            payment.getPaymentDate(),
            payment.getPaymentMethod(),
            payment.getPaymentStatus(),
            payment.getCurrency(),
            payment.getTransactionId(),
            payment.getOrderId()
        );
    }

    public static Payment mapToPayment(PaymentDto paymentDto){
        return new Payment(
            paymentDto.getPaymentId(),
            paymentDto.getAmount(),
            paymentDto.getPaymentDate(),
            paymentDto.getPaymentMethod(),
            paymentDto.getPaymentStatus(),
            paymentDto.getCurrency(),
            paymentDto.getTransactionId(),
            paymentDto.getOrderId()
        );
    }
}
