package com.studentsalesmanagementsystem.entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
