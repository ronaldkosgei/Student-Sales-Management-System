package com.studentsalesmanagementsystem.mapper;

import com.studentsalesmanagementsystem.dto.InventoryDto;
import com.studentsalesmanagementsystem.entity.Inventory;

public class InventoryMapper {

    public static InventoryDto mapToInventoryDto(Inventory inventory){
        return new InventoryDto(
                inventory.getProductId(),
                inventory.getProductName(),
                inventory.getProductDescription(),
                inventory.getStockQuantity(),
                inventory.getProductPrice(),
                inventory.getReOrderLevel(),
                inventory.getLocation(),
                inventory.getLastUpdated()

        );
    }

    public static Inventory mapToInventory(InventoryDto inventoryDto){
        return new Inventory(
                inventoryDto.getProductId(),
                inventoryDto.getProductName(),
                inventoryDto.getProductDescription(),
                inventoryDto.getStockQuantity(),
                inventoryDto.getProductPrice(),
                inventoryDto.getReOrderLevel(),
                inventoryDto.getLocation(),
                inventoryDto.getLastUpdated()

        );
    }
}
