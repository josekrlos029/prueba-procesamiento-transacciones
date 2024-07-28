package com.sofka.sofkatransactionservice.domain.service;

import com.sofka.sofkatransactionservice.application.rest.ExceptionHandlerRest;
import com.sofka.sofkatransactionservice.application.rest.request.TransactionRequest;
import com.sofka.sofkatransactionservice.application.rest.response.TransactionResponse;
import com.sofka.sofkatransactionservice.domain.model.Transaction;
import com.sofka.sofkatransactionservice.domain.ports.event.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class.getName());

    private final EventPublisher eventPublisher;

    @Override
    public TransactionResponse createTransaction(TransactionRequest transactionRequest) {

        Transaction transaction = Transaction.create(
                transactionRequest.transactionId(),
                transactionRequest.timestamp(),
                transactionRequest.deviceNumber(),
                transactionRequest.userId(),
                transactionRequest.geoPosition(),
                transactionRequest.amount()
        );

        Thread sendEvent = new Thread(()-> eventPublisher.createTransactionEvent(transaction));
        sendEvent.start();

        return new TransactionResponse(
                transaction.getTransactionId(),
                transaction.getTimestamp(),
                transaction.getDeviceNumber(),
                transaction.getUserId(),
                transaction.getGeoPosition(),
                transaction.getAmount()
        );

    }

    @Override
    public void transactionCounter() {
        Thread sendEvent = new Thread(eventPublisher::transactionCounterEvent);
        sendEvent.start();
    }
}
