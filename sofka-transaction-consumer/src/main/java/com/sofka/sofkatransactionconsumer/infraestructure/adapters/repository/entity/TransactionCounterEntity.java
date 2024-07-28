package com.sofka.sofkatransactionconsumer.infraestructure.adapters.repository.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document("transaction-count")
@RequiredArgsConstructor
@Data
public class TransactionCounterEntity {

    @Id
    @MongoId
    private String id;
    private LocalDateTime timestamp;
    private LocalDate date;
    private Long count;

}
