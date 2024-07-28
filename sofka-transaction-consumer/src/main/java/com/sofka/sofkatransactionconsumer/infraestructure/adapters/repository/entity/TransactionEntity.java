package com.sofka.sofkatransactionconsumer.infraestructure.adapters.repository.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Document("transaction")
@RequiredArgsConstructor
@Data
public class TransactionEntity {

    @Id
    @MongoId
    private String id;
    private String transactionId;
    private LocalDateTime timestamp;
    private String deviceNumber;
    private Long userId;
    private String geoPosition;
    private Double amount;
    private LocalDateTime createdAt;

}
