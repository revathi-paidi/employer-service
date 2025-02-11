package com.example.employer_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "employer_claim_review")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerClaimReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String claimantName;
    @Column(name = "claimant_ssn", nullable = false)
    private String claimantSSN;
    private LocalDate claimDate;
    private String employerName;
    private String status;
    private String remarks;
    private LocalDate reviewDate;
}
