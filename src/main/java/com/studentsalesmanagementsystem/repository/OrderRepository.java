package com.studentsalesmanagementsystem.repository;


import com.studentsalesmanagementsystem.entity.Order;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends ReactiveCrudRepository<Order, String> {


}
