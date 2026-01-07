package com.marvelhospitalitymanagement.room_reservation_service.usecases.strategy;

import com.marvelhospitalitymanagement.room_reservation_service.adapter.out.payment.PaymentServiceAdapter;
import com.marvelhospitalitymanagement.room_reservation_service.adapter.out.reservation.dto.RoomReservationDto;
import com.marvelhospitalitymanagement.room_reservation_service.domain.constant.PaymentType;
import com.marvelhospitalitymanagement.room_reservation_service.domain.enums.PaymentStatusEnum;
import com.marvelhospitalitymanagement.room_reservation_service.domain.enums.ReservationStatusEnum;
import com.marvelhospitalitymanagement.room_reservation_service.domain.exceptions.InvalidPaymentException;
import com.marvelhospitalitymanagement.room_reservation_service.domain.exceptions.PaymentNotConfirmedException;
import com.marvelhospitalitymanagement.room_reservation_service.domain.model.PaymentDetails;
import com.marvelhospitalitymanagement.room_reservation_service.domain.model.RoomReservationExecuted;
import com.marvelhospitalitymanagement.room_reservation_service.port.out.PaymentServicePort;
import com.marvelhospitalitymanagement.room_reservation_service.port.out.RoomReservationPort;
import com.marvelhospitalitymanagement.room_reservation_service.usecases.command.RoomReservationConfirmCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service(PaymentType.CREDIT_CARD)
@RequiredArgsConstructor
public class PaymentCreditCardStrategy implements PaymentStrategy {

    private final PaymentServicePort paymentServicePort;
    private final RoomReservationPort roomReservationPort;

    public RoomReservationExecuted execute(RoomReservationConfirmCommand command){
        PaymentDetails paymentDetails = paymentServicePort.getPaymentDetails(command.paymentReference());

        if(PaymentStatusEnum.CONFIRMED.equals(paymentDetails.status())){
            final var reservationStatus = ReservationStatusEnum.CONFIRMED.getReservationStatus();
            RoomReservationDto roomReservationDto = roomReservationPort.saveReservation(command, reservationStatus);
            return new RoomReservationExecuted(roomReservationDto.id(), reservationStatus);
        }

        throw new PaymentNotConfirmedException("The credit card payment is not confirmed.");
    }
}
