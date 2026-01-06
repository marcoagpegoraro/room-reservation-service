package com.marvelhospitalitymanagement.room_reservation_service.port.out;

import com.marvelhospitalitymanagement.room_reservation_service.domain.model.PaymentDetails;

public interface PaymentServicePort {

    PaymentDetails getPaymentDetails(final String paymentId);
}
