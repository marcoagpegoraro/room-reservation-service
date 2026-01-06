package com.marvelhospitalitymanagement.room_reservation_service.adapter.out.reservation.dto;

import java.time.OffsetDateTime;

public record RoomReservationDto (
        Long id,
        String roomNumber,
        OffsetDateTime reservationStartDate,
        OffsetDateTime reservationEndDate,
        String customerName,
        String roomSegment,
        String paymentMode,
        String paymentReference,
        String reservationStatus
) {
}
