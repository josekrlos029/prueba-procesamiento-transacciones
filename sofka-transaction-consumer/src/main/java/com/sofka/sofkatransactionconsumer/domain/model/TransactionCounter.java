package com.sofka.sofkatransactionconsumer.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TransactionCounter {
    LocalDate date;
    LocalDateTime timestamp;
    Long transactionCount;

}
