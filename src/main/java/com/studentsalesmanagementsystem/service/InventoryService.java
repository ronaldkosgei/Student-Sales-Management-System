package com.studentsalesmanagementsystem.service;

import com.studentsalesmanagementsystem.dto.InventoryDto;
import com.studentsalesmanagementsystem.entity.Inventory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InventoryService {


    Mono<Inventory> saveInventory(InventoryDto inventoryDto);

    Mono<InventoryDto> getInventory(String productId);

    Flux<InventoryDto> getAllInventory();

    Mono<InventoryDto> updateInventory(String productId, InventoryDto inventoryDto);

    Mono<Void> deleteInventory(String productId);

    Mono<InventoryDto> getProductPrice(String productId);

    Mono<InventoryDto> getProductQuantity(String productId);

}
