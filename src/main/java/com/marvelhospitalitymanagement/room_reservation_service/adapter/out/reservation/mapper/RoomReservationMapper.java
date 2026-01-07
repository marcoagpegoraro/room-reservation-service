package com.marvelhospitalitymanagement.room_reservation_service.adapter.out.reservation.mapper;

import com.marvelhospitalitymanagement.room_reservation_service.adapter.out.reservation.RoomReservationJpaEntity;
import com.marvelhospitalitymanagement.room_reservation_service.domain.model.RoomReservationSaved;
import com.marvelhospitalitymanagement.room_reservation_service.domain.model.RoomReservationConfirmCommand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoomReservationMapper {
    RoomReservationSaved commandToDto(RoomReservationConfirmCommand command);
    @Mapping(target = ".", source = "command")
    @Mapping(target = "reservationStatus", source = "reservationStatus")
    RoomReservationJpaEntity commandToJpa(RoomReservationConfirmCommand command, String reservationStatus);
    RoomReservationSaved jpaToDto(RoomReservationJpaEntity roomReservationJpaEntity);
    RoomReservationJpaEntity dtoToJpa(RoomReservationSaved roomReservationSaved);

}
