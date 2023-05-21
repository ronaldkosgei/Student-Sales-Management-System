package com.studentsalesmanagementsystem.service;


import com.studentsalesmanagementsystem.dto.ReportDto;
import com.studentsalesmanagementsystem.entity.Report;
import com.studentsalesmanagementsystem.mapper.ReportMapper;
import com.studentsalesmanagementsystem.repository.ReportRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public Mono<Report> saveReport(ReportDto reportDto) {
        Report report = ReportMapper.mapToReport(reportDto);
        Mono<Report> savedReporting = reportRepository.save(report);
        return savedReporting.map(reportingEntity -> ReportMapper.mapToReport(reportDto));
    }

    @Override
    public Mono<ReportDto> getReportById(String reportId) {
        Mono<Report> reportMono = reportRepository.findById(reportId);
        return reportMono.map(report -> ReportMapper.mapToReportDto(report));
    }

    @Override
    public Flux<ReportDto> getAllReports() {
        Flux<Report> reportFlux = reportRepository.findAll();
        return reportFlux.map(report -> ReportMapper.mapToReportDto(report));
    }

    @Override
    public Mono<ReportDto> updateReport(String reportId ,
                                     ReportDto reportDto) {
        Mono<Report> reportMono = reportRepository.findById(reportId);
        return reportMono.flatMap(report -> {
            report.setReportName(reportDto.getReportName());
            report.setSalesPerfomance(reportDto.getSalesPerfomance());
            report.setSalesPerfomanceByMonth(reportDto.getSalesPerfomanceByMonth());
            report.setSalesPerfomanceByYear(reportDto.getSalesPerfomanceByYear());
            report.setSalesChannels(reportDto.getSalesChannels());
            report.setSalesTarget(reportDto.getSalesTarget());
            report.setFinancialInformation(reportDto.getFinancialInformation());
            report.setReportDate(reportDto.getReportDate());
            report.setServicesOffered(reportDto.getServicesOffered());
            return reportRepository.save(report);
        }).map(report -> ReportMapper.mapToReportDto(report));
    }
}
