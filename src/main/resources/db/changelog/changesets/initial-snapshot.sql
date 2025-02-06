-- liquibase formatted sql

-- changeset revathi:employer_response:1
CREATE TABLE employer_response (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    claim_id BIGINT NOT NULL,
    employer_name VARCHAR(255) NOT NULL,
    response_status VARCHAR(20) CHECK (response_status IN ('APPROVED', 'REJECTED')),
    remarks TEXT
);
