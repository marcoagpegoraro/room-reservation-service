package com.marvelhospitalitymanagement.room_reservation_service.usecases.strategy;

import com.marvelhospitalitymanagement.room_reservation_service.domain.constant.PaymentType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class PaymentFactory {
    private final Map<String, PaymentStrategy> paymentStrategies;

    public PaymentStrategy get(String fileType) {
        final var paymentStrategy = paymentStrategies.get(fileType);
        if (Objects.isNull(paymentStrategy)) {
            throw new IllegalArgumentException("Unsupported payment strategy");
        }
        return paymentStrategy;
    }
}
