package com.marvelhospitalitymanagement.room_reservation_service.adapter.in.messaging;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class BankTransferPaymentUpdateConsumer {
    @KafkaListener(topics = "${kafka.topic-name}", groupId = "${kafka.group-id}")
    public void consume(String message) {
        System.out.println("message = " + message);
    }
}
