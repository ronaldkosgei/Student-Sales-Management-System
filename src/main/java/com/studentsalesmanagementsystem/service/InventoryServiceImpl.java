package com.studentsalesmanagementsystem.service;


import com.studentsalesmanagementsystem.dto.InventoryDto;
import com.studentsalesmanagementsystem.dto.OrderDto;
import com.studentsalesmanagementsystem.entity.Customer;
import com.studentsalesmanagementsystem.entity.Inventory;
import com.studentsalesmanagementsystem.entity.Order;
import com.studentsalesmanagementsystem.mapper.InventoryMapper;
import com.studentsalesmanagementsystem.mapper.OrderMapper;
import com.studentsalesmanagementsystem.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class InventoryServiceImpl implements InventoryService{

    private final InventoryRepository inventoryRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Mono<Inventory> saveInventory(InventoryDto inventoryDto) {
        Inventory inventory = InventoryMapper.mapToInventory(inventoryDto);
        Mono<Inventory> savedInventory = inventoryRepository.save(inventory);
        return savedInventory.map(inventoryEntity -> InventoryMapper.mapToInventory(inventoryDto));
    }

    @Override
    public Mono<InventoryDto> getInventory(String productId) {
        Mono<Inventory> inventoryMono = inventoryRepository.findById(productId);
        return inventoryMono.map(inventory -> InventoryMapper.mapToInventoryDto(inventory));
    }

    @Override
    public Flux<InventoryDto> getAllInventory() {
        Flux<Inventory> inventoryFlux = inventoryRepository.findAll();
        return inventoryFlux
                .map((inventory) -> InventoryMapper.mapToInventoryDto(inventory))
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<InventoryDto> updateInventory(String productId, InventoryDto inventoryDto) {
        Mono<Inventory> inventoryDtoMono = inventoryRepository.findById(productId);
        return inventoryDtoMono.flatMap((existingInventory) -> {
            existingInventory.setProductName(inventoryDto.getProductName());
            existingInventory.setProductDescription(inventoryDto.getProductDescription());
            existingInventory.setStockQuantity(inventoryDto.getStockQuantity());
            existingInventory.setProductPrice(inventoryDto.getProductPrice());
            existingInventory.setReOrderLevel(inventoryDto.getReOrderLevel());
            existingInventory.setLocation(inventoryDto.getLocation());
            existingInventory.setLastUpdated(inventoryDto.getLastUpdated());
            return inventoryRepository.save(existingInventory);
        }).map(inventory -> InventoryMapper.mapToInventoryDto(inventory));

    }

    @Override
    public Mono<Void> deleteInventory(String productId) {
        Mono<Inventory> inventoryMono = inventoryRepository.findById(productId);
        return inventoryMono.flatMap(inventory -> inventoryRepository.delete(inventory));
    }

    @Override
    public Mono<InventoryDto> getProductPrice(String productId) {
        Mono<Inventory> inventoryMono = inventoryRepository.findById(productId);
        return inventoryMono.map(inventory -> InventoryMapper.mapToInventoryDto(inventory));
    }

    @Override
    public Mono<InventoryDto> getProductQuantity(String productId) {
        Mono<Inventory> inventoryMono = inventoryRepository.findById(productId);
        return inventoryMono.map(inventory -> InventoryMapper.mapToInventoryDto(inventory));
    }


}
