package com.example.employer_service.mapper;

import com.example.employer_service.dto.ClaimRequestDto;
import com.example.employer_service.entity.EmployerClaimReview;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployerClaimReviewMapper {
    EmployerClaimReview toEntity(ClaimRequestDto claimRequestDto);
}
