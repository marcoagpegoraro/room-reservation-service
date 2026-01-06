package com.marvelhospitalitymanagement.room_reservation_service.adapter.out.payment.dto;

import com.marvelhospitalitymanagement.room_reservation_service.domain.enums.PaymentStatusEnum;

import java.time.OffsetDateTime;

public record PaymentServiceResponse (
        OffsetDateTime lastUpdateDate,
        PaymentStatusEnum status
){
}
