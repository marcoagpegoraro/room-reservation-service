package com.marvelhospitalitymanagement.room_reservation_service.usecases.strategy;

import com.marvelhospitalitymanagement.room_reservation_service.adapter.out.reservation.dto.RoomReservationDto;
import com.marvelhospitalitymanagement.room_reservation_service.domain.constant.PaymentType;
import com.marvelhospitalitymanagement.room_reservation_service.domain.enums.ReservationStatusEnum;
import com.marvelhospitalitymanagement.room_reservation_service.domain.model.RoomReservationExecuted;
import com.marvelhospitalitymanagement.room_reservation_service.port.out.RoomReservationPort;
import com.marvelhospitalitymanagement.room_reservation_service.usecases.command.RoomReservationConfirmCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service(PaymentType.CASH)
@RequiredArgsConstructor
public class PaymentCashStrategy implements PaymentStrategy {

    private final RoomReservationPort roomReservationPort;

    public RoomReservationExecuted execute(RoomReservationConfirmCommand command){
        final var reservationStatus = ReservationStatusEnum.CONFIRMED.getReservationStatus();
        RoomReservationDto roomReservationDto = roomReservationPort.saveReservation(command, reservationStatus);
        return new RoomReservationExecuted(roomReservationDto.id(), reservationStatus);
    }
}
