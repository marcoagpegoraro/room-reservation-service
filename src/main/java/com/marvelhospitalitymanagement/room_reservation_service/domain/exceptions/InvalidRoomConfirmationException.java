package com.marvelhospitalitymanagement.room_reservation_service.domain.exceptions;

public class InvalidRoomConfirmationException extends RuntimeException {
    public InvalidRoomConfirmationException(String message) {
        super(message);
    }
}
