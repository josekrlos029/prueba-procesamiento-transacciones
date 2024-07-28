package com.sofka.sofkatransactionconsumer.infraestructure.adapters.repository;

import com.sofka.sofkatransactionconsumer.infraestructure.adapters.repository.entity.TransactionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;

public interface TransactionCrudRepository extends MongoRepository<TransactionEntity, String> {

    @Query(value = "{createdAt: { $gte: ?0, $lte: ?1 }}", count = true)
    Long countTransactions(LocalDateTime startOfDay, LocalDateTime endOfDay);


}
