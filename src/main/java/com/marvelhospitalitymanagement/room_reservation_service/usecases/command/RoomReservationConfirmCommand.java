package com.marvelhospitalitymanagement.room_reservation_service.usecases.command;

import com.marvelhospitalitymanagement.room_reservation_service.domain.enums.PaymentModeEnum;
import com.marvelhospitalitymanagement.room_reservation_service.domain.enums.RoomSegmentEnum;

import java.time.OffsetDateTime;

public record RoomReservationConfirmCommand (
        String customerName,
        Integer roomNumber,
        OffsetDateTime reservationStartDate,
        OffsetDateTime reservationEndDate,
        RoomSegmentEnum roomSegmentEnum,
        PaymentModeEnum paymentModeEnum,
        String paymentReference
){
}