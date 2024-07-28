package com.sofka.sofkatransactionservice.configuration;

import com.sofka.sofkatransactionservice.domain.ports.event.EventPublisher;
import com.sofka.sofkatransactionservice.domain.service.TransactionService;
import com.sofka.sofkatransactionservice.domain.service.TransactionServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionConfig {

    @Bean
    public TransactionService transactionService(
            EventPublisher eventPublisher
    ) {
        return new TransactionServiceImpl(eventPublisher);
    }
}
