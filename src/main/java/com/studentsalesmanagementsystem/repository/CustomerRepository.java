package com.studentsalesmanagementsystem.repository;


import com.studentsalesmanagementsystem.entity.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CustomerRepository extends ReactiveCrudRepository<Customer, String> {
    Mono<Customer> findByEmail(String email);

    Mono<Void> deleteByEmail(String email);
}
