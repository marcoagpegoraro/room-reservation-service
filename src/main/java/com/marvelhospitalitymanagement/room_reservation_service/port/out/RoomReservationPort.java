package com.marvelhospitalitymanagement.room_reservation_service.port.out;

import com.marvelhospitalitymanagement.room_reservation_service.domain.model.RoomReservationSaved;
import com.marvelhospitalitymanagement.room_reservation_service.domain.model.RoomReservationConfirmCommand;

public interface RoomReservationPort {

    RoomReservationSaved saveReservation(RoomReservationConfirmCommand command, String reservationStatus);
    void updateReservationPaymentStatus(Long reservationId, String reservationStatus);
}
