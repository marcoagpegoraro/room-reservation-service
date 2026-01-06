package com.marvelhospitalitymanagement.room_reservation_service.domain.model;

public record RoomReservationExecuted(
        Long reservationId,
        String reservationStatus
){
}
