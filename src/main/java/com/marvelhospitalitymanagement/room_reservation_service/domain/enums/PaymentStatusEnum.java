package com.marvelhospitalitymanagement.room_reservation_service.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentStatusEnum {
    CONFIRMED("CONFIRMED"),
    REJECTED("REJECTED");

    private final String paymentStatus;

}
