package com.marvelhospitalitymanagement.room_reservation_service.adapter.out.reservation;

import com.marvelhospitalitymanagement.room_reservation_service.domain.model.RoomReservationSaved;
import com.marvelhospitalitymanagement.room_reservation_service.adapter.out.reservation.mapper.RoomReservationMapper;
import com.marvelhospitalitymanagement.room_reservation_service.domain.exceptions.ReservationNotFoundException;
import com.marvelhospitalitymanagement.room_reservation_service.port.out.RoomReservationPort;
import com.marvelhospitalitymanagement.room_reservation_service.domain.model.RoomReservationConfirmCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RoomReservationAdapter implements RoomReservationPort {

    private final RoomReservationJpaRepository roomReservationJpaRepository;
    private final RoomReservationMapper roomReservationMapper;

    public RoomReservationSaved saveReservation(RoomReservationConfirmCommand command, String reservationStatus){
        RoomReservationJpaEntity roomReservationJpaEntity = roomReservationMapper.commandToJpa(command, reservationStatus);
        RoomReservationJpaEntity savedRoomReservationEntity = roomReservationJpaRepository.save(roomReservationJpaEntity);
        return roomReservationMapper.jpaToDto(savedRoomReservationEntity);
    }

    public void updateReservationPaymentStatus(Long reservationId, String reservationStatus){
        Optional<RoomReservationJpaEntity> reservationOptional = roomReservationJpaRepository.findById(reservationId);
        if(reservationOptional.isEmpty()){
            throw new ReservationNotFoundException("The provided reservation ID was not found: " + reservationId);
        }
        final var reservation = reservationOptional.get();
        reservation.setReservationStatus(reservationStatus);
        roomReservationJpaRepository.save(reservation);
    }
}
