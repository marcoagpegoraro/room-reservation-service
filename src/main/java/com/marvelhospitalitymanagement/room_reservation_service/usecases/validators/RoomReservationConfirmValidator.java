package com.marvelhospitalitymanagement.room_reservation_service.usecases.validators;

import com.marvelhospitalitymanagement.room_reservation_service.domain.model.RoomReservationConfirmCommand;

public interface RoomReservationConfirmValidator {

    void validate(RoomReservationConfirmCommand request);
}
