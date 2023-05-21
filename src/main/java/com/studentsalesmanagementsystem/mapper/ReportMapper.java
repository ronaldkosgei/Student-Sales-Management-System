package com.studentsalesmanagementsystem.mapper;

import com.studentsalesmanagementsystem.dto.ReportDto;
import com.studentsalesmanagementsystem.entity.Report;

public class ReportMapper {

    public static ReportDto mapToReportDto(Report report) {
        return new ReportDto(
            report.getReportId(),
            report.getReportName(),
            report.getSalesPerfomance(),
            report.getSalesPerfomanceByMonth(),
            report.getSalesPerfomanceByYear(),
            report.getSalesChannels(),
            report.getSalesTarget(),
            report.getFinancialInformation(),
            report.getReportDate(),
            report.getServicesOffered()
        );
    }

    public static Report mapToReport(ReportDto reportDto) {
        return new Report(
            reportDto.getReportId(),
            reportDto.getReportName(),
            reportDto.getSalesPerfomance(),
            reportDto.getSalesPerfomanceByMonth(),
            reportDto.getSalesPerfomanceByYear(),
            reportDto.getSalesChannels(),
            reportDto.getSalesTarget(),
            reportDto.getFinancialInformation(),
            reportDto.getReportDate(),
            reportDto.getServicesOffered()
        );
    }
}
