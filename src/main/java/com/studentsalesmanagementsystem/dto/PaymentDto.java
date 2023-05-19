package com.studentsalesmanagementsystem.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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
    @SequenceGenerator(
            name = "payment_sequence",
            sequenceName = "payment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(generator = "payment_sequence")
    private String paymentId;

    private String amount;

    private String paymentDate;

    private String paymentMethod;

    private String paymentStatus;

    private String currency;

    private String transactionId;

    private String orderId;
}
