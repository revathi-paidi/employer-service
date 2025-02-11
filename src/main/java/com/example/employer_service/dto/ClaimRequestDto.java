package com.example.employer_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClaimRequestDto {
    private String claimantName;
    private String claimantSSN;
    private LocalDate claimDate;
    private String employerName;
    private String status;
}