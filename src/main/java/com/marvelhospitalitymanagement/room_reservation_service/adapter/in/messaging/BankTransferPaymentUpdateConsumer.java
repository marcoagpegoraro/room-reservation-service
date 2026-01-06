package com.marvelhospitalitymanagement.room_reservation_service.adapter.in.messaging;

import com.marvelhospitalitymanagement.room_reservation_service.adapter.in.messaging.dto.BankTransferPaymentUpdateMessage;
import com.marvelhospitalitymanagement.room_reservation_service.port.in.UpdateReservationPayedByBankTransferPort;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
@RequiredArgsConstructor
public class BankTransferPaymentUpdateConsumer {

    private final UpdateReservationPayedByBankTransferPort updateReservationPayedByBankTransferPort;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "${kafka.topic-name}", groupId = "${kafka.group-id}")
    public void consume(final String message) {
        final var bankTransferPaymentUpdateMessage = objectMapper.readValue(message, BankTransferPaymentUpdateMessage.class);
        updateReservationPayedByBankTransferPort.execute(bankTransferPaymentUpdateMessage.getReservationId());
    }

}
