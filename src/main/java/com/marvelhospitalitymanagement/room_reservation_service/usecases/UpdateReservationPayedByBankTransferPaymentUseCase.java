package com.marvelhospitalitymanagement.room_reservation_service.usecases;

import com.marvelhospitalitymanagement.room_reservation_service.domain.enums.ReservationStatusEnum;
import com.marvelhospitalitymanagement.room_reservation_service.domain.model.RoomReservationExecuted;
import com.marvelhospitalitymanagement.room_reservation_service.port.in.ConfirmRoomReservationPort;
import com.marvelhospitalitymanagement.room_reservation_service.port.in.UpdateReservationPayedByBankTransferPort;
import com.marvelhospitalitymanagement.room_reservation_service.port.out.RoomReservationPort;
import com.marvelhospitalitymanagement.room_reservation_service.usecases.strategy.PaymentFactory;
import com.marvelhospitalitymanagement.room_reservation_service.usecases.strategy.PaymentStrategy;
import com.marvelhospitalitymanagement.room_reservation_service.usecases.validators.RoomReservationConfirmValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UpdateReservationPayedByBankTransferPaymentUseCase implements UpdateReservationPayedByBankTransferPort {

    private final RoomReservationPort roomReservationPort;

    @Override
    public void execute(final Long reservationId) {
        roomReservationPort.updateReservationPaymentStatus(reservationId, ReservationStatusEnum.CONFIRMED.getReservationStatus());
    }
}
