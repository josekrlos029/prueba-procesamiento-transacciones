package com.sofka.sofkatransactionservice.infraestructure.adapters.task;

import com.sofka.sofkatransactionservice.domain.ports.task.ScheduledTask;
import com.sofka.sofkatransactionservice.domain.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScheduledTaskImpl implements ScheduledTask {

    private final TransactionService transactionService;

    @Override
    //@Scheduled(cron = "59 59 23 * * *")
    @Scheduled(cron = "*/5 * * * * *")
    public void transactionCounter() {
        transactionService.transactionCounter();
    }
}
