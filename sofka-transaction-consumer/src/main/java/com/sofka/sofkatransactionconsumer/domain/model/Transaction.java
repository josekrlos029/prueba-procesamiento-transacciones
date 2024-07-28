package com.sofka.sofkatransactionconsumer.domain.model;

import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
public class Transaction {

    private String transactionId;
    private LocalDateTime timestamp;
    private String deviceNumber;
    private Long userId;
    private String geoPosition;
    private Double amount;

    public static Transaction create(
            String transactionId,
            String timestamp,
            String deviceNumber,
            Long userId,
            String geoPosition,
            Double amount
    ) {
        Transaction transaction = new Transaction();
        transaction.transactionId = transactionId;
        transaction.timestamp = LocalDateTime.parse(timestamp, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        transaction.deviceNumber = deviceNumber;
        transaction.userId = userId;
        transaction.geoPosition = geoPosition;
        transaction.amount = amount;
        return transaction;
    }

}
