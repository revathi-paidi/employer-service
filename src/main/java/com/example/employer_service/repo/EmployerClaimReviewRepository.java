package com.example.employer_service.repo;

import com.example.employer_service.entity.EmployerClaimReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerClaimReviewRepository extends JpaRepository<EmployerClaimReview, Long> {
}
