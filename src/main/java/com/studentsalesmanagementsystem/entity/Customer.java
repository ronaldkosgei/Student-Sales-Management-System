package com.studentsalesmanagementsystem.entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "tbl_customer")
public class Customer {

    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(generator = "customer_sequence")
    private String customerId;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String address;

    private String city;

    private String accountInformation;

    private String password;
}
