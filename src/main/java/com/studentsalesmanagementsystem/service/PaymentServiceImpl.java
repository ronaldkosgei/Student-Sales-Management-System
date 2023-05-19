package com.studentsalesmanagementsystem.service;


import com.studentsalesmanagementsystem.dto.PaymentDto;
import com.studentsalesmanagementsystem.entity.Payment;
import com.studentsalesmanagementsystem.mapper.PaymentMapper;
import com.studentsalesmanagementsystem.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PaymentServiceImpl implements PaymentService {


    @Autowired
    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Mono<Payment> savePayment(PaymentDto paymentDto) {
        Payment payment = PaymentMapper.mapToPayment(paymentDto);
        Mono<Payment> savedPayment = paymentRepository.save(payment);
        return savedPayment.map(paymentEntity -> PaymentMapper.mapToPayment(paymentDto));
    }


    @Override
    public Mono<PaymentDto> updatePayment(PaymentDto paymentDto, String paymentId) {
        Mono<Payment> paymentMono = paymentRepository.findById(paymentId);
        return paymentMono.flatMap((existingPayment) -> {

            existingPayment.setAmount(paymentDto.getAmount());
            existingPayment.setPaymentDate(paymentDto.getPaymentDate());
            existingPayment.setPaymentMethod(paymentDto.getPaymentMethod());
            existingPayment.setPaymentStatus(paymentDto.getPaymentStatus());
            existingPayment.setCurrency(paymentDto.getCurrency());
            existingPayment.setTransactionId(paymentDto.getTransactionId());
            existingPayment.setOrderId(paymentDto.getOrderId());
            return paymentRepository.save(existingPayment);
        }).map(payment -> PaymentMapper.mapToPaymentDto(payment));

    }

    @Override
    public Flux<PaymentDto> getAllPayments() {
        Flux<Payment> paymentFlux = paymentRepository.findAll();
        return paymentFlux
                .map((payment) -> PaymentMapper.mapToPaymentDto(payment))
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<PaymentDto> getPayment(String paymentId) {
        Mono<Payment> paymentMono = paymentRepository.findById(paymentId);
        return paymentMono.map(payment -> PaymentMapper.mapToPaymentDto(payment));
    }
}



