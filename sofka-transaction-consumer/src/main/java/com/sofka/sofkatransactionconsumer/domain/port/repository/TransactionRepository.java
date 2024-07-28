package com.sofka.sofkatransactionconsumer.domain.port.repository;

import com.sofka.sofkatransactionconsumer.domain.model.Transaction;

public interface TransactionRepository {

    Transaction save(Transaction transaction);

    Long getTodayTransactionCount();

}
