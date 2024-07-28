package com.sofka.sofkatransactionconsumer.domain.service;

import com.sofka.sofkatransactionconsumer.domain.model.Transaction;
import com.sofka.sofkatransactionconsumer.domain.model.TransactionCounter;
import com.sofka.sofkatransactionconsumer.domain.port.repository.TransactionCounterRepository;
import com.sofka.sofkatransactionconsumer.domain.port.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class.getName());

    private final TransactionRepository transactionRepository;
    private final TransactionCounterRepository transactionCounterRepository;

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public void transactionCounter() {
        logger.info("Transaction counter");
        Long transactionCount = transactionRepository.getTodayTransactionCount();
        logger.info("Today transaction count: " + transactionCount);
        transactionCounterRepository.save(new TransactionCounter(LocalDate.now(), LocalDateTime.now(), transactionCount));
        logger.info("Transaction counter saved");
    }
}
