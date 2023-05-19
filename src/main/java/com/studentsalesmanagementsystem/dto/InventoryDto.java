package com.studentsalesmanagementsystem.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "tbl_inventory")
public class InventoryDto {


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

    private String ReOrderLevel;

    private String location;

    private String lastUpdated;
}
