package com.sofka.sofkatransactionconsumer.infraestructure.adapters.repository;

import com.sofka.sofkatransactionconsumer.domain.model.TransactionCounter;
import com.sofka.sofkatransactionconsumer.domain.port.repository.TransactionCounterRepository;
import com.sofka.sofkatransactionconsumer.infraestructure.adapters.repository.entity.TransactionCounterEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionCounterRepositoryImpl implements TransactionCounterRepository {

    private final TransactionCounterCrudRepository transactionCounterCrudRepository;
    @Override
    public TransactionCounter save(TransactionCounter transactionCounter) {
        TransactionCounterEntity transactionCounterEntity = new TransactionCounterEntity();
        transactionCounterEntity.setTimestamp(transactionCounter.getTimestamp());
        transactionCounterEntity.setDate(transactionCounter.getDate());
        transactionCounterEntity.setCount(transactionCounter.getTransactionCount());

        transactionCounterCrudRepository.save(transactionCounterEntity);
        return transactionCounter;
    }

}
