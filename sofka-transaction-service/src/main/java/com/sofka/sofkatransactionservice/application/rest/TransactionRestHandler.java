package com.sofka.sofkatransactionservice.application.rest;

import com.sofka.sofkatransactionservice.application.rest.request.TransactionRequest;
import com.sofka.sofkatransactionservice.application.rest.response.TransactionResponse;
import com.sofka.sofkatransactionservice.domain.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionRestHandler {

    Logger logger = LoggerFactory.getLogger(TransactionRestHandler.class.getName());

    private final TransactionService transactionService;


    public TransactionRestHandler(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("")
    public ResponseEntity<TransactionResponse> createTransaction(@RequestBody TransactionRequest transactionRequest) {
        logger.info("Creating transaction");
        return ResponseEntity.ok(transactionService.createTransaction(transactionRequest));
    }

}
