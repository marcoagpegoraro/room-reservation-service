package com.marvelhospitalitymanagement.room_reservation_service.domain.exceptions;

public class InvalidPaymentException extends RuntimeException {
    public InvalidPaymentException(String message) {
        super(message);
    }
}
