package com.sofka.sofkatransactionconsumer.configuration;

import com.sofka.sofkatransactionconsumer.domain.port.repository.TransactionCounterRepository;
import com.sofka.sofkatransactionconsumer.domain.port.repository.TransactionRepository;
import com.sofka.sofkatransactionconsumer.domain.service.TransactionService;
import com.sofka.sofkatransactionconsumer.domain.service.TransactionServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionConfig {

    @Bean
    public TransactionService transactionService(
            TransactionRepository transactionRepository,
            TransactionCounterRepository transactionCounterRepository
    ) {
        return new TransactionServiceImpl(transactionRepository, transactionCounterRepository);
    }

}
