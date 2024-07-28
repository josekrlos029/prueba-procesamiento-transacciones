package com.sofka.sofkatransactionservice.infraestructure.adapters.event;

import com.sofka.sofkatransactionservice.domain.model.Transaction;
import com.sofka.sofkatransactionservice.domain.ports.event.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventPublisherImpl implements EventPublisher {

    private static final String transactionTopicId = "new-transaction";
    private static final String transactionCounterTopicId = "transaction-counter";

    private final KafkaTemplate<String, Transaction> transactionTemplate;
    private final KafkaTemplate<String, String> transactionCounterTemplate;

    Logger logger = LoggerFactory.getLogger(EventPublisherImpl.class);

    @Override
    public void createTransactionEvent(Transaction transaction) {
        try {

            transactionTemplate.send(transactionTopicId, transaction);
            logger.info("Transaction event published: {}", transaction);

        } catch (Exception e) {
            logger.error("Error publishing transaction event: ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void transactionCounterEvent() {
        try {

            transactionCounterTemplate.send(transactionCounterTopicId, "transaction-counter");
            logger.info("Transaction counter event published: {}", transactionCounterTopicId);

        } catch (Exception e) {
            logger.error("Error publishing transaction event: ", e);
            throw new RuntimeException(e);
        }
    }
}
