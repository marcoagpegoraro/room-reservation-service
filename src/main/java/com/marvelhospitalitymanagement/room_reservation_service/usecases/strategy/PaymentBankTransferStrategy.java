package com.marvelhospitalitymanagement.room_reservation_service.usecases.strategy;

import com.marvelhospitalitymanagement.room_reservation_service.domain.model.RoomReservationSaved;
import com.marvelhospitalitymanagement.room_reservation_service.domain.constant.PaymentType;
import com.marvelhospitalitymanagement.room_reservation_service.domain.enums.ReservationStatusEnum;
import com.marvelhospitalitymanagement.room_reservation_service.domain.model.RoomReservationExecuted;
import com.marvelhospitalitymanagement.room_reservation_service.port.out.RoomReservationPort;
import com.marvelhospitalitymanagement.room_reservation_service.usecases.command.RoomReservationConfirmCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service(PaymentType.BANK_TRANSFER)
@RequiredArgsConstructor
public class PaymentBankTransferStrategy implements PaymentStrategy {
    private final RoomReservationPort roomReservationPort;

    public RoomReservationExecuted execute(RoomReservationConfirmCommand command){
        final var reservationStatus = ReservationStatusEnum.PENDING_PAYMENT.getReservationStatus();
        RoomReservationSaved roomReservationSaved = roomReservationPort.saveReservation(command, reservationStatus);
        return new RoomReservationExecuted(roomReservationSaved.id(), reservationStatus);
    }
}
