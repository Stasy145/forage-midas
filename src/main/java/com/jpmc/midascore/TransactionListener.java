package com.jpmc.midascore;

import com.jpmc.midascore.foundation.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionListener {
    
    private static final Logger logger = LoggerFactory.getLogger(TransactionListener.class);

    @KafkaListener(topics = "${kafka.topic}")
    public void receiveTransaction(Transaction transaction) {
        logger.info("Received transaction: {}", transaction);
        System.out.println("DEBUG - Transaction amount: " + transaction.getAmount());
    }
}
