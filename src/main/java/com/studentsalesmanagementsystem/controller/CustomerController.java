package com.studentsalesmanagementsystem.controller;


import com.studentsalesmanagementsystem.dto.CustomerDto;
import com.studentsalesmanagementsystem.entity.Customer;
import com.studentsalesmanagementsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping("/save")
    public Mono<Customer> saveCustomer(@RequestBody CustomerDto customerDto){
        return customerService.saveCustomer(customerDto);
    }

    @GetMapping("/get/{id}")
    public Mono<CustomerDto> getCustomerById(@PathVariable("id") String customerId){
        return customerService.getCustomerById(customerId);
    }

    @GetMapping("/get")
    public Mono<CustomerDto> getCustomerByEmail(@RequestParam("email") String email){
        return customerService.getCustomerByEmail(email);
    }

    @GetMapping("/get/all")
    public Flux<CustomerDto> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @PutMapping("/update")
    public Mono<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto,
                                            @PathVariable String customerId){
        return customerService.updateCustomer(customerDto, customerId);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteCustomerById(@PathVariable("customerId") String customerId){
        return customerService.deleteCustomerById(customerId);
    }

    @DeleteMapping("/delete")
    public Mono<Void> deleteCustomerByEmail(@RequestParam("email") String email){
        return customerService.deleteCustomerByEmail(email);
    }

}
