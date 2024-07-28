package com.sofka.sofkatransactionconsumer.infraestructure.adapters.event;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sofka.sofkatransactionconsumer.domain.model.Transaction;
import com.sofka.sofkatransactionconsumer.domain.port.event.EventConsumer;
import com.sofka.sofkatransactionconsumer.domain.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventConsumerImpl implements EventConsumer {

    Logger logger = LoggerFactory.getLogger(EventConsumerImpl.class);

    private static final String transactionTopicId = "new-transaction";
    private static final String transactionCounterTopicId = "transaction-counter";

    private final TransactionService transactionService;

    @Override
    @KafkaListener(topics = transactionTopicId, groupId = "sofka-transaction-consumer")
    public void consumeCreateTransactionEvent(String transactionString) {
        logger.info("Consumer consume Kafka message -> {}", transactionString);
        JsonObject jsonObject = JsonParser.parseString(transactionString).getAsJsonObject();
        Transaction transaction = Transaction.create(
                jsonObject.get("transactionId").getAsString(),
                jsonObject.get("timestamp").getAsString(),
                jsonObject.get("deviceNumber").getAsString(),
                jsonObject.get("userId").getAsLong(),
                jsonObject.get("geoPosition").getAsString(),
                jsonObject.get("amount").getAsDouble()
        );

        transactionService.createTransaction(transaction);

    }

    @Override
    @KafkaListener(topics = transactionCounterTopicId, groupId = "sofka-transaction-consumer")
    public void consumeTransactionCounterEvent() {
        logger.info("Consumer consume Kafka message -> transactionCounter");
        transactionService.transactionCounter();
    }
}
