package com.studentsalesmanagementsystem.repository;

import com.studentsalesmanagementsystem.entity.Report;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ReportRepository extends ReactiveCrudRepository<Report, String>{
}
