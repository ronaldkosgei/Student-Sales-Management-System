package com.studentsalesmanagementsystem.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "customer")
public class CustomerDto {

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
