package com.example.employer_service.service;

import com.example.employer_service.dto.ClaimRequestDto;
import com.example.employer_service.dto.EmployerResponseDto;
import com.example.employer_service.dto.EmployerReviewRequestDto;
import com.example.employer_service.entity.EmployerClaimReview;
import com.example.employer_service.kafka.Producer;
import com.example.employer_service.mapper.EmployerClaimReviewMapper;
import com.example.employer_service.repo.EmployerClaimReviewRepository;
import lombok.AllArgsConstructor;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class EmployerClaimReviewService {

    private final EmployerClaimReviewRepository employerClaimReviewRepository;
    private final EmployerClaimReviewMapper employerClaimReviewMapper;
    private final Producer kafkaProducerService;

    public void processClaimRequest(ClaimRequestDto claimRequest) {
        EmployerClaimReview employerClaimReview = employerClaimReviewMapper.toEntity(claimRequest);
        employerClaimReviewRepository.save(employerClaimReview);
    }

    public EmployerClaimReview updateClaimReview(Long id, EmployerReviewRequestDto reviewDto) {
        EmployerClaimReview review = employerClaimReviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employer claim review not found for id: " + id));

        // Update the status, remarks, and review date
        review.setStatus(reviewDto.getStatus());
        review.setRemarks(reviewDto.getRemarks());
        review.setReviewDate(LocalDate.now());

        EmployerClaimReview updatedReview = employerClaimReviewRepository.save(review);

        // Prepare the response DTO to send to the Claim Service using the claim's SSN.
        EmployerResponseDto responseDto = new EmployerResponseDto(
                updatedReview.getClaimantSSN(),
                updatedReview.getStatus(),
                updatedReview.getRemarks(),
                updatedReview.getReviewDate()
        );
        // Send the response to the Claim Service using Kafka.
        kafkaProducerService.sendMessage("claim-status-update-topic", responseDto);
        return updatedReview;
    }
}