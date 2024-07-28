package com.sofka.sofkatransactionconsumer.domain.port.event;

import com.sofka.sofkatransactionconsumer.domain.model.Transaction;

public interface EventConsumer {
    void consumeCreateTransactionEvent(String transaction);

    void consumeTransactionCounterEvent();
}
