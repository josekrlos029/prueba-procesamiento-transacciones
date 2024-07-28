package com.sofka.sofkatransactionservice.domain.service;

import com.sofka.sofkatransactionservice.application.rest.request.TransactionRequest;
import com.sofka.sofkatransactionservice.application.rest.response.TransactionResponse;

public interface TransactionService {

    TransactionResponse createTransaction(TransactionRequest transactionRequest);

    void transactionCounter();
}
