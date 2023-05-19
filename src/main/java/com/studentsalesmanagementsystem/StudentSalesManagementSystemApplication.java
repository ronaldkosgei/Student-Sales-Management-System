package com.studentsalesmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class StudentSalesManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentSalesManagementSystemApplication.class, args);
    }

}
