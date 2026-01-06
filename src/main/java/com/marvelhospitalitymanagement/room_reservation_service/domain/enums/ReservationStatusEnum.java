package com.marvelhospitalitymanagement.room_reservation_service.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ReservationStatusEnum {
    PENDING_PAYMENT("PENDING_PAYMENT"),
    CONFIRMED("CONFIRMED"),
    CANCELLED("CANCELLED");

    private final String reservationStatus;

}
