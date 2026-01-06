package com.marvelhospitalitymanagement.room_reservation_service.port.in;

import com.marvelhospitalitymanagement.room_reservation_service.domain.model.RoomReservationExecuted;
import com.marvelhospitalitymanagement.room_reservation_service.usecases.command.RoomReservationConfirmCommand;

public interface ConfirmRoomReservationPort {

    RoomReservationExecuted execute(RoomReservationConfirmCommand command);

}
