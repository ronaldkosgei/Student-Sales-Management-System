package com.studentsalesmanagementsystem.service;

import com.studentsalesmanagementsystem.dto.CustomerDto;
import com.studentsalesmanagementsystem.entity.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Mono<Customer> saveCustomer(CustomerDto customerDto);

    Mono<CustomerDto> getCustomerById(String customerId);

    Mono<CustomerDto> getCustomerByEmail(String email);

    Mono<CustomerDto> updateCustomer(CustomerDto customerDto, String customerId);

    Mono<Void> deleteCustomerById(String customerId);

    Mono<Void> deleteCustomerByEmail(String email);

    Flux<CustomerDto> getAllCustomers();
}
