package com.marvelhospitalitymanagement.room_reservation_service.domain.model;

import com.marvelhospitalitymanagement.room_reservation_service.domain.enums.PaymentStatusEnum;

import java.time.OffsetDateTime;

public record PaymentDetails(
        OffsetDateTime lastUpdateDate,
        PaymentStatusEnum status) {
}
