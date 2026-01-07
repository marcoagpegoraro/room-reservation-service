package com.marvelhospitalitymanagement.room_reservation_service.usecases.strategy;

import com.marvelhospitalitymanagement.room_reservation_service.domain.model.RoomReservationExecuted;
import com.marvelhospitalitymanagement.room_reservation_service.domain.model.RoomReservationConfirmCommand;

public interface PaymentStrategy {
    RoomReservationExecuted execute(RoomReservationConfirmCommand command);
}
