package com.example.employer_service.controller;

import com.example.employer_service.dto.EmployerReviewRequestDto;
import com.example.employer_service.entity.EmployerClaimReview;
import com.example.employer_service.service.EmployerClaimReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employer/review")
@AllArgsConstructor
public class EmployerClaimReviewController {

    private final EmployerClaimReviewService reviewService;

    @PutMapping("/{id}")
    public ResponseEntity<EmployerClaimReview> reviewClaim(
            @PathVariable Long id,
            @RequestBody EmployerReviewRequestDto reviewDto) {

        EmployerClaimReview updatedReview = reviewService.updateClaimReview(id, reviewDto);
        return ResponseEntity.ok(updatedReview);
    }
}
