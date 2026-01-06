package com.marvelhospitalitymanagement.room_reservation_service.domain.exceptions;

public class IntegrationException extends RuntimeException {
    public IntegrationException(String message) {
        super(message);
    }
}
