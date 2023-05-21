package com.studentsalesmanagementsystem.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "tbl_reporting" )
public class ReportDto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String reportId;

    private String reportName;

    private String salesPerfomance;

    private String salesPerfomanceByMonth;

    private String salesPerfomanceByYear;

    private String salesChannels;

    private String salesTarget;

    private String financialInformation;

    private String reportDate;

    private String servicesOffered;
}
