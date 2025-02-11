-- liquibase formatted sql

-- changeset revathi:employer_response:1
CREATE TABLE employer_response (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    claim_id BIGINT NOT NULL,
    employer_name VARCHAR(255) NOT NULL,
    response_status VARCHAR(20) CHECK (response_status IN ('APPROVED', 'REJECTED')),
    remarks TEXT
);

-- changeset revathi:employer_claim_review:1
CREATE TABLE employer_claim_review (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    claimant_name VARCHAR(255) NOT NULL,
    claimant_ssn VARCHAR(20) NOT NULL,
    claim_date DATE NOT NULL,
    employer_name VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL,
    remarks TEXT,
    review_date DATE
);