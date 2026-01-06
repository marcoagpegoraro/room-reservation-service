package com.marvelhospitalitymanagement.room_reservation_service.adapter.in.web.dto;

import com.marvelhospitalitymanagement.room_reservation_service.domain.enums.PaymentModeEnum;
import com.marvelhospitalitymanagement.room_reservation_service.domain.enums.RoomSegmentEnum;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public record RoomReservationConfirmRequest (
        @NotNull String customerName,
        @NotNull Integer roomNumber,
        @NotNull OffsetDateTime reservationStartDate,
        @NotNull OffsetDateTime reservationEndDate,
        @NotNull RoomSegmentEnum roomSegment,
        @NotNull PaymentModeEnum paymentMode,
        @NotNull String paymentReference
){
}
