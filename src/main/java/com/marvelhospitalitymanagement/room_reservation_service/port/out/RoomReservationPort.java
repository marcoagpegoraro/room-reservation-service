package com.marvelhospitalitymanagement.room_reservation_service.port.out;

import com.marvelhospitalitymanagement.room_reservation_service.adapter.out.reservation.dto.RoomReservationDto;
import com.marvelhospitalitymanagement.room_reservation_service.domain.model.PaymentDetails;
import com.marvelhospitalitymanagement.room_reservation_service.usecases.command.RoomReservationConfirmCommand;

public interface RoomReservationPort {

    RoomReservationDto saveReservation(RoomReservationConfirmCommand command, String reservationStatus);
    void updateReservationPaymentStatus(Long reservationId, String reservationStatus);
}
