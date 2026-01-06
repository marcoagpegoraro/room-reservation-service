package com.marvelhospitalitymanagement.room_reservation_service.adapter.in.web.dto;

public record RoomReservationConfirmResponse (
        String reservationId,
        String reservationStatus
){
}
