package com.studentsalesmanagementsystem.mapper;

import com.studentsalesmanagementsystem.dto.CustomerDto;
import com.studentsalesmanagementsystem.entity.Customer;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(Customer customer) {
        return new CustomerDto(
                customer.getCustomerId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhoneNumber(),
                customer.getAddress(),
                customer.getCity(),
                customer.getAccountInformation(),
                customer.getPassword()
        );
    }

    public static Customer mapToCustomer(CustomerDto customerDto) {
        return new Customer(
                customerDto.getCustomerId(),
                customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getEmail(),
                customerDto.getPhoneNumber(),
                customerDto.getAddress(),
                customerDto.getCity(),
                customerDto.getAccountInformation(),
                customerDto.getPassword()
        );
    }
}
