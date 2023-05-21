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
@Document(value = "tbl_inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String productId;

    private String productName;

    private String productDescription;

    private String stockQuantity;

    private String productPrice;

    private String reOrderLevel;

    private String location;

    private String lastUpdated;
}
