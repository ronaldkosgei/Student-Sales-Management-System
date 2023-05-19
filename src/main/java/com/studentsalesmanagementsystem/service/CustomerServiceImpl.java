package com.studentsalesmanagementsystem.service;


import com.studentsalesmanagementsystem.dto.CustomerDto;
import com.studentsalesmanagementsystem.dto.PaymentDto;
import com.studentsalesmanagementsystem.entity.Customer;
import com.studentsalesmanagementsystem.entity.Payment;
import com.studentsalesmanagementsystem.mapper.CustomerMapper;
import com.studentsalesmanagementsystem.mapper.PaymentMapper;
import com.studentsalesmanagementsystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService{


    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Mono<Customer> saveCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto);
        Mono<Customer> savedCustomer = customerRepository.save(customer);
        return savedCustomer.map(customerEntity -> CustomerMapper.mapToCustomer(customerDto));
    }

    @Override
    public Mono<CustomerDto> getCustomerById(String customerId) {
        Mono<Customer> customerMono = customerRepository.findById(String.valueOf(customerId));
        return customerMono.map(customer -> CustomerMapper.mapToCustomerDto(customer));
    }

    @Override
    public Flux<CustomerDto> getAllCustomers() {
        Flux<Customer> customerFlux = customerRepository.findAll();
        return customerFlux.map(customer -> CustomerMapper.mapToCustomerDto(customer));
    }

    @Override
    public Mono<CustomerDto> getCustomerByEmail(String email) {
        Mono<Customer> customerMono = customerRepository.findByEmail(email);
        return customerMono.map(customer -> CustomerMapper.mapToCustomerDto(customer));
    }

    @Override
    public Mono<CustomerDto> updateCustomer(CustomerDto customerDto, String customerId) {
        Mono<Customer> customerMono = customerRepository.findById(customerId);
        return customerMono.flatMap((existingCustomer) -> {
            existingCustomer.setFirstName(customerDto.getFirstName());
            existingCustomer.setLastName(customerDto.getLastName());
            existingCustomer.setEmail(customerDto.getEmail());
            existingCustomer.setPhoneNumber(customerDto.getPhoneNumber());
            existingCustomer.setAddress(customerDto.getAddress());
            existingCustomer.setCity(customerDto.getCity());
            existingCustomer.setAccountInformation(customerDto.getAccountInformation());
            existingCustomer.setPassword(customerDto.getPassword());
            return customerRepository.save(existingCustomer);
        }).map(customer -> CustomerMapper.mapToCustomerDto(customer));
    }

    @Override
    public Mono<Void> deleteCustomerById(String customerId) {
        Mono<Customer> customerMono = customerRepository.findById(customerId);
        return customerMono.flatMap(customer -> customerRepository.delete(customer));
    }

    @Override
    public Mono<Void> deleteCustomerByEmail(String email) {
        Mono<Customer> customerMono = customerRepository.findByEmail(email);
        return customerMono.flatMap(customer -> customerRepository.delete(customer));
    }

}
