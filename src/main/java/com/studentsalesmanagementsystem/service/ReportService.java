package com.studentsalesmanagementsystem.service;

import com.studentsalesmanagementsystem.dto.ReportDto;
import com.studentsalesmanagementsystem.entity.Report;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReportService {

    Mono<Report> saveReport(ReportDto reportDto);

    Mono<ReportDto> getReportById(String reportId);

    Flux<ReportDto> getAllReports();

    Mono<ReportDto> updateReport(String reportId, ReportDto reportDto);
}
