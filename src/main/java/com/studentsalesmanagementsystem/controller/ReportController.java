package com.studentsalesmanagementsystem.controller;


import com.studentsalesmanagementsystem.dto.ReportDto;
import com.studentsalesmanagementsystem.entity.Report;
import com.studentsalesmanagementsystem.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reporting")
public class ReportController {

    @Autowired
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/save")
    public Mono<Report> saveReport(@RequestBody ReportDto reportDto) {
        return reportService.saveReport(reportDto);
    }

    @GetMapping("/get/{reportingId}")
    public Mono<ReportDto> getReportById(@PathVariable String reportId) {
        return reportService.getReportById(reportId);
    }

    @GetMapping("/get/all")
    public Flux<ReportDto> getAllReports() {
        return reportService.getAllReports();
    }

    @PutMapping("/update/{reportId}")
    public Mono<ReportDto> updateReport(@PathVariable String reportId,
                                      @RequestBody ReportDto reportDto) {
        return reportService.updateReport(reportId, reportDto);
    }
}
