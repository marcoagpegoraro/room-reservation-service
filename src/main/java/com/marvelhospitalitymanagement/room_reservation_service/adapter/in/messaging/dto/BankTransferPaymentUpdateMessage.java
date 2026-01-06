package com.marvelhospitalitymanagement.room_reservation_service.adapter.in.messaging.dto;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

public record BankTransferPaymentUpdateMessage (
        String paymentId,
        String debtorAccountnumber,
        String amountReceived,
        String transactionDescription
) {

    public Long getReservationId(){
        if(transactionDescription == null)
            return null;

        return Long.valueOf(transactionDescription.substring(transactionDescription.lastIndexOf(" ")+1));
    }
}
