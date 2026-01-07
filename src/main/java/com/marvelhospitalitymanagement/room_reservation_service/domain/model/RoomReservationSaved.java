package com.marvelhospitalitymanagement.room_reservation_service.domain.model;

import java.time.OffsetDateTime;

public record RoomReservationSaved(
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
