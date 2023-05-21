package com.studentsalesmanagementsystem.entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "tbl_payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String paymentId;

    private String amount;

    private String paymentDate;

    private String paymentMethod;

    private String paymentStatus;

    private String currency;

    private String transactionId;

    private String orderId;
}
