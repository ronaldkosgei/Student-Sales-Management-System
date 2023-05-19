package com.studentsalesmanagementsystem.repository;

import com.studentsalesmanagementsystem.entity.Payment;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentRepository extends ReactiveCrudRepository <Payment, String>{
}
