package com.marvelhospitalitymanagement.room_reservation_service.domain.enums;

import com.marvelhospitalitymanagement.room_reservation_service.domain.constant.PaymentType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentModeEnum {
    CASH(PaymentType.CASH),
    CREDIT_CARD(PaymentType.CREDIT_CARD),
    BANK_TRANSFER(PaymentType.BANK_TRANSFER);

    private final String paymentMode;

}
