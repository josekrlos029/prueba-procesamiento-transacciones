package com.sofka.sofkatransactionconsumer.domain.service;

import com.sofka.sofkatransactionconsumer.domain.model.Transaction;

public interface TransactionService {
    Transaction createTransaction(Transaction transaction);

    void transactionCounter();

}
