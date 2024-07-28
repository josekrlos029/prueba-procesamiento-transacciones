package com.sofka.sofkatransactionservice.domain.ports.event;

import com.sofka.sofkatransactionservice.domain.model.Transaction;

public interface EventPublisher {

    void createTransactionEvent(Transaction transaction);

    void transactionCounterEvent();
}
