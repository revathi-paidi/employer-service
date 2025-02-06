package com.example.employer_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employer_response")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerResponseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long claimId; // Reference to Claim ID
    private String employerName;
    private String responseStatus; // APPROVED, REJECTED
    private String remarks;
}
