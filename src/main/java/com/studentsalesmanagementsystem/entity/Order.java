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
@Document(value = "tbl_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String orderId;

    private  String items;

    private String quantity;

    private String price;

    private String orderStatus;

    private String orderDate;

    private String paymentInformation;
}
