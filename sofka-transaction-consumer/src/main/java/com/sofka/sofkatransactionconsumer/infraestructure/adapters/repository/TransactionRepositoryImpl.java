package com.sofka.sofkatransactionconsumer.infraestructure.adapters.repository;

import com.sofka.sofkatransactionconsumer.domain.model.Transaction;
import com.sofka.sofkatransactionconsumer.domain.port.repository.TransactionRepository;
import com.sofka.sofkatransactionconsumer.infraestructure.adapters.repository.entity.TransactionEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

@Component
@RequiredArgsConstructor
public class TransactionRepositoryImpl implements TransactionRepository {

    //private final TransactionMapper transactionMapper;
    private final TransactionCrudRepository transactionCrudRepository;


    @Override
    public Transaction save(Transaction transaction) {

        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setTransactionId(transaction.getTransactionId());
        transactionEntity.setTimestamp(transaction.getTimestamp());
        transactionEntity.setDeviceNumber(transaction.getDeviceNumber());
        transactionEntity.setUserId(transaction.getUserId());
        transactionEntity.setGeoPosition(transaction.getGeoPosition());
        transactionEntity.setAmount(transaction.getAmount());
        transactionEntity.setCreatedAt(LocalDateTime.now());

        transactionCrudRepository.save(transactionEntity);
        return transaction;
    }

    @Override
    public Long getTodayTransactionCount() {
        LocalDateTime gte  = LocalDate.now().atTime(LocalTime.MIN);
        LocalDateTime lte  = LocalDate.now().atTime(LocalTime.MAX);
        return transactionCrudRepository.countTransactions(gte, lte);
    }


}
