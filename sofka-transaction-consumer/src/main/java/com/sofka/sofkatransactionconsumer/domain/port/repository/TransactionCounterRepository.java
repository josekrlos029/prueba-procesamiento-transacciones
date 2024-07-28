package com.sofka.sofkatransactionconsumer.domain.port.repository;

import com.sofka.sofkatransactionconsumer.domain.model.TransactionCounter;

public interface TransactionCounterRepository {

    TransactionCounter save(TransactionCounter transactionCounter);

}
