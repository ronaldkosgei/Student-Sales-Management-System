package com.studentsalesmanagementsystem.controller;


import com.studentsalesmanagementsystem.dto.InventoryDto;
import com.studentsalesmanagementsystem.entity.Inventory;
import com.studentsalesmanagementsystem.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }

    @PostMapping("/save")
    public Mono<Inventory> saveInventory(@RequestBody InventoryDto inventoryDto){
        return inventoryService.saveInventory(inventoryDto);
    }
    @GetMapping("/inventory{id}")
    public  Mono<InventoryDto> getInventory(@PathVariable("id") String productId){
        return inventoryService.getInventory(productId);
    }

    @GetMapping("/all")
    public Flux<InventoryDto> getAllInventory(){
        return inventoryService.getAllInventory();
    }

    @GetMapping("/price{id}")
    public Mono<InventoryDto> getProductPrice(@PathVariable("id") String productId){
        return inventoryService.getProductPrice(productId);
    }

    @GetMapping("/quantity{id}")
    public Mono<InventoryDto> getProductQuantity(@PathVariable("id") String productId){
        return inventoryService.getProductQuantity(productId);
    }

    @PutMapping("/update{id}")
    public Mono<InventoryDto> updateInventory(@PathVariable("id") String productId,
                                              @RequestBody InventoryDto inventoryDto){
        return inventoryService.updateInventory(productId, inventoryDto);
    }

    @DeleteMapping("/delete{id}")
    public Mono<Void> deleteInventory(@PathVariable("id") String productId){
        return inventoryService.deleteInventory(productId);
    }
}
