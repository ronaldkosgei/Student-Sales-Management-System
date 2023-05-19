package com.studentsalesmanagementsystem.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "tbl_order")
public class OrderDto {

    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(generator = "order_sequence")
    private String orderId;

    private  String items;

    private String quantity;

    private String price;

    private String orderStatus;

    private String orderDate;

    private String paymentInformation;
}
