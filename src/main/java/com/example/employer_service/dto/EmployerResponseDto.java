package com.example.employer_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerResponseDto {
    private String claimantSSN;
    private String status;
    private String remarks;
    private LocalDate reviewDate;
}
