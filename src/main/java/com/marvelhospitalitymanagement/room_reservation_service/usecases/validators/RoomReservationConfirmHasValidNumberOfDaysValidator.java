package com.marvelhospitalitymanagement.room_reservation_service.usecases.validators;

import com.marvelhospitalitymanagement.room_reservation_service.domain.exceptions.InvalidRoomConfirmationException;
import com.marvelhospitalitymanagement.room_reservation_service.usecases.command.RoomReservationConfirmCommand;
import org.springframework.stereotype.Component;

import java.time.temporal.ChronoUnit;

@Component
public class RoomReservationConfirmHasValidNumberOfDaysValidator implements RoomReservationConfirmValidator {

    private static final int MAX_NUMBER_OF_DAYS_FOR_ROOM_RESERVATION_ALLOWED = 30;

    public void validate(RoomReservationConfirmCommand request){
        long roomReservationDays = ChronoUnit.DAYS.between(request.reservationStartDate(), request.reservationEndDate());
        if(roomReservationDays <= MAX_NUMBER_OF_DAYS_FOR_ROOM_RESERVATION_ALLOWED){
            throw new InvalidRoomConfirmationException("The maximum number of days for a room reservation is " + MAX_NUMBER_OF_DAYS_FOR_ROOM_RESERVATION_ALLOWED + ".");
        }
    }
}
