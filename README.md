# Claim Processing Microservices

This project demonstrates a microservices architecture using Spring Boot and Kafka for asynchronous communication between services, with MySQL as the primary database.

## Overview

- **Claim Service:**  
  - Creates claims.
  - Publishes claim events (`ClaimRequestDto`) to Kafka (`claim-created-topic`).

- **Employer Service:**  
  - Consumes claim events.
  - Inserts claim review data into the `employer_claim_review` table (includes remarks and review date).
  - Provides a PUT endpoint (`/api/employer/review/{id}`) to update claim reviews.
  - Publishes review updates (`EmployerResponseDto`) to Kafka (`claim-status-update-topic`).

## Features

- **Asynchronous Messaging:**  
  Decoupled communication via Apache Kafka.
- **REST APIs:**  
  Endpoints for creating claims and reviewing/updating claims.
- **Database Integration:**  
  Uses MySQL with Spring Data JPA/Hibernate and Liquibase for migrations.
- **Generic Kafka Consumers/Producers:**  
  Minimal boilerplate with error handling and retry mechanisms.
- **DTO Mapping:**  
  Uses MapStruct for clean mapping between DTOs and entities.
