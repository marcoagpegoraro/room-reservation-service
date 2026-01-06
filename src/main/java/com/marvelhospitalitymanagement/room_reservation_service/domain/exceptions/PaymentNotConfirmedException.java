package com.marvelhospitalitymanagement.room_reservation_service.domain.exceptions;

public class PaymentNotConfirmedException extends RuntimeException {
    public PaymentNotConfirmedException(String message) {
        super(message);
    }
}
