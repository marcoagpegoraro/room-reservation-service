package com.marvelhospitalitymanagement.room_reservation_service.usecases.validators;

import com.marvelhospitalitymanagement.room_reservation_service.adapter.in.web.dto.RoomReservationConfirmRequest;
import com.marvelhospitalitymanagement.room_reservation_service.usecases.command.RoomReservationConfirmCommand;

import java.time.temporal.ChronoUnit;

public interface RoomReservationConfirmValidator {

    void validate(RoomReservationConfirmCommand request);
}
