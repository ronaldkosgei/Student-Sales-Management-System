package com.studentsalesmanagementsystem.repository;

import com.studentsalesmanagementsystem.entity.Inventory;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InventoryRepository extends ReactiveCrudRepository<Inventory, String> {
}
