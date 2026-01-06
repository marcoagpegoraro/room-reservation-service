package com.marvelhospitalitymanagement.room_reservation_service.adapter.out.payment;

import com.marvelhospitalitymanagement.room_reservation_service.adapter.out.payment.dto.PaymentServiceRequest;
import com.marvelhospitalitymanagement.room_reservation_service.adapter.out.payment.dto.PaymentServiceResponse;
import com.marvelhospitalitymanagement.room_reservation_service.adapter.out.payment.mapper.PaymentDetailsMapper;
import com.marvelhospitalitymanagement.room_reservation_service.domain.exceptions.IntegrationException;
import com.marvelhospitalitymanagement.room_reservation_service.domain.model.PaymentDetails;
import com.marvelhospitalitymanagement.room_reservation_service.port.out.PaymentServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequiredArgsConstructor
public class PaymentServiceAdapter implements PaymentServicePort {

    private final PaymentServiceClient paymentServiceClient;
    private final PaymentDetailsMapper paymentDetailsMapper;

    public PaymentDetails getPaymentDetails(final String paymentId){
        final var request = new PaymentServiceRequest(paymentId);
        ResponseEntity<PaymentServiceResponse> response = paymentServiceClient.getPaymentDetails(request);

        if(response.getStatusCode().is2xxSuccessful()){
            return paymentDetailsMapper.responseToDetails(response.getBody());
        }

        throw new IntegrationException("Payment service currently unavailable. Reason: " + response.getBody());
    }
}
