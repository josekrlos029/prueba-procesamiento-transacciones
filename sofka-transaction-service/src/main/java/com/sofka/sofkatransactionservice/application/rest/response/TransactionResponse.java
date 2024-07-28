package com.sofka.sofkatransactionservice.application.rest.response;

public record TransactionResponse(
        String transactionId,
        String timestamp,
        String deviceNumber,
        Long userId,
        String geoPosition,
        Double amount
) {
}
