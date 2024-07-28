package com.sofka.sofkatransactionservice.application.rest.request;

public record TransactionRequest(
        String transactionId,
        String timestamp,
        String deviceNumber,
        Long userId,
        String geoPosition,
        Double amount
        ) {
}
