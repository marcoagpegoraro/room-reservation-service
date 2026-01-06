package com.marvelhospitalitymanagement.room_reservation_service.adapter.out.payment;

import com.marvelhospitalitymanagement.room_reservation_service.adapter.out.payment.dto.PaymentServiceRequest;
import com.marvelhospitalitymanagement.room_reservation_service.adapter.out.payment.dto.PaymentServiceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "payment-service-client")
public interface PaymentServiceClient {

    @RequestMapping("/credit-card-payment-api")
    ResponseEntity<PaymentServiceResponse> getPaymentDetails(@RequestBody PaymentServiceRequest request);
}
