package com.example.employer_service.kafka;

import com.example.employer_service.dto.ClaimRequestDto;
import com.example.employer_service.service.EmployerClaimReviewService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Consumer {

    private final EmployerClaimReviewService employerClaimReviewService;

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);
    @KafkaListener(topics = "claim-created-topic",
            groupId = "claim-group",
            containerFactory = "kafkaListenerContainerFactory")
    public void consume(ConsumerRecord<String, ClaimRequestDto> record) {
        ClaimRequestDto claimRequest = record.value();
        logger.info("Received ClaimRequestDto: {}", claimRequest);

        employerClaimReviewService.processClaimRequest(claimRequest);
        logger.info("Claim processed and saved to employer_claim_review table.");
    }
}

