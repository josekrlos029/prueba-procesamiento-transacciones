package com.sofka.sofkatransactionconsumer.infraestructure.adapters.repository;

import com.sofka.sofkatransactionconsumer.infraestructure.adapters.repository.entity.TransactionCounterEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionCounterCrudRepository extends MongoRepository<TransactionCounterEntity, String> {
}
