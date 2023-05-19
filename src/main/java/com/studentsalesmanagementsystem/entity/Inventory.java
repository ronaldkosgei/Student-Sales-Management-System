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
@Document(value = "tbl_inventory")
public class Inventory {

    @Id
    @SequenceGenerator(
            name = "inventory_sequence",
            sequenceName = "inventory_sequence",
            allocationSize = 1
    )
    @GeneratedValue(generator = "inventory_sequence")
    private String productId;

    private String productName;

    private String productDescription;

    private String stockQuantity;

    private String productPrice;

    private String reOrderLevel;

    private String location;

    private String lastUpdated;
}
