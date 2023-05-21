package com.studentsalesmanagementsystem.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(value = "tbl_payment")
public class PaymentDto {


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
