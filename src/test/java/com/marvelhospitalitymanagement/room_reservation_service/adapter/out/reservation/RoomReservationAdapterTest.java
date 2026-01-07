package com.marvelhospitalitymanagement.room_reservation_service.adapter.out.reservation;

import com.marvelhospitalitymanagement.room_reservation_service.domain.model.RoomReservationSaved;
import com.marvelhospitalitymanagement.room_reservation_service.adapter.out.reservation.mapper.RoomReservationMapper;
import com.marvelhospitalitymanagement.room_reservation_service.domain.exceptions.ReservationNotFoundException;
import com.marvelhospitalitymanagement.room_reservation_service.usecases.command.RoomReservationConfirmCommand;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoomReservationAdapterTest {

    @Mock
    private RoomReservationJpaRepository roomReservationJpaRepository;

    @Mock
    private RoomReservationMapper roomReservationMapper;

    @InjectMocks
    private RoomReservationAdapter roomReservationAdapter;

    @Test
    void saveReservation_shouldSaveAndReturnDto() {
        // GIVEN
        RoomReservationConfirmCommand command = Mockito.mock(RoomReservationConfirmCommand.class);
        String reservationStatus = "CONFIRMED";

        RoomReservationJpaEntity jpaEntity = new RoomReservationJpaEntity();
        RoomReservationJpaEntity savedJpaEntity = new RoomReservationJpaEntity();
        RoomReservationSaved expectedDto = new RoomReservationSaved(1L, "", OffsetDateTime.now(), OffsetDateTime.now(), "", "", "", "", "");

        when(roomReservationMapper.commandToJpa(command, reservationStatus))
                .thenReturn(jpaEntity);
        when(roomReservationJpaRepository.save(jpaEntity))
                .thenReturn(savedJpaEntity);
        when(roomReservationMapper.jpaToDto(savedJpaEntity))
                .thenReturn(expectedDto);

        // WHEN
        RoomReservationSaved result =
                roomReservationAdapter.saveReservation(command, reservationStatus);

        // THEN
        assertNotNull(result);
        assertEquals(expectedDto, result);

        verify(roomReservationMapper).commandToJpa(command, reservationStatus);
        verify(roomReservationJpaRepository).save(jpaEntity);
        verify(roomReservationMapper).jpaToDto(savedJpaEntity);
    }

    @Test
    void updateReservationPaymentStatus_shouldUpdateStatus_whenReservationExists() {
        // GIVEN
        Long reservationId = 1L;
        String newStatus = "PAID";

        RoomReservationJpaEntity reservation = new RoomReservationJpaEntity();
        reservation.setReservationStatus("PENDING");

        when(roomReservationJpaRepository.findById(reservationId))
                .thenReturn(Optional.of(reservation));

        // WHEN
        roomReservationAdapter.updateReservationPaymentStatus(reservationId, newStatus);

        // THEN
        assertEquals(newStatus, reservation.getReservationStatus());
        verify(roomReservationJpaRepository).save(reservation);
    }

    @Test
    void updateReservationPaymentStatus_shouldThrowException_whenReservationNotFound() {
        // GIVEN
        Long reservationId = 99L;

        when(roomReservationJpaRepository.findById(reservationId))
                .thenReturn(Optional.empty());

        // WHEN / THEN
        ReservationNotFoundException exception =
                assertThrows(
                        ReservationNotFoundException.class,
                        () -> roomReservationAdapter.updateReservationPaymentStatus(
                                reservationId, "PAID")
                );

        assertTrue(exception.getMessage().contains(reservationId.toString()));
        verify(roomReservationJpaRepository, Mockito.never()).save(Mockito.any());
    }
}