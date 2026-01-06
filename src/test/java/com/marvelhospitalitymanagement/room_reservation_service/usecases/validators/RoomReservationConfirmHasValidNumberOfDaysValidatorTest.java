package com.marvelhospitalitymanagement.room_reservation_service.usecases.validators;

import com.marvelhospitalitymanagement.room_reservation_service.domain.enums.PaymentModeEnum;
import com.marvelhospitalitymanagement.room_reservation_service.domain.enums.RoomSegmentEnum;
import com.marvelhospitalitymanagement.room_reservation_service.domain.exceptions.InvalidRoomConfirmationException;
import com.marvelhospitalitymanagement.room_reservation_service.usecases.command.RoomReservationConfirmCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;


class RoomReservationConfirmHasValidNumberOfDaysValidatorTest {

    private RoomReservationConfirmHasValidNumberOfDaysValidator validator;

    @BeforeEach
    void setUp() {
        validator = new RoomReservationConfirmHasValidNumberOfDaysValidator();
    }

    @Test
    void validate_shouldPass_whenReservationDaysLessThanMax() {
        // GIVEN
        RoomReservationConfirmCommand command = new RoomReservationConfirmCommand("", 1,
                OffsetDateTime.now(),
                OffsetDateTime.now().plusDays(10),
                RoomSegmentEnum.LARGE, PaymentModeEnum.CASH, ""
        );

        // WHEN / THEN
        assertDoesNotThrow(() -> validator.validate(command));
    }

    @Test
    void validate_shouldPass_whenReservationDaysExactlyAtMaxLimit() {
        // GIVEN
        RoomReservationConfirmCommand command = new RoomReservationConfirmCommand("", 1,
                OffsetDateTime.now(),
                OffsetDateTime.now().plusDays(30),
                RoomSegmentEnum.LARGE, PaymentModeEnum.CASH, ""
        );

        // WHEN / THEN
        assertDoesNotThrow(() -> validator.validate(command));
    }

    @Test
    void validate_shouldThrowException_whenReservationDaysExceedMaxLimit() {
        // GIVEN

        RoomReservationConfirmCommand command = new RoomReservationConfirmCommand("", 1,
                OffsetDateTime.now(),
                OffsetDateTime.now().plusDays(31),
                RoomSegmentEnum.LARGE, PaymentModeEnum.CASH, ""
        );

        // WHEN / THEN
        InvalidRoomConfirmationException exception =
                assertThrows(
                        InvalidRoomConfirmationException.class,
                        () -> validator.validate(command)
                );

        assertEquals(
                "The maximum number of days for a room reservation is 30.",
                exception.getMessage()
        );
    }
}