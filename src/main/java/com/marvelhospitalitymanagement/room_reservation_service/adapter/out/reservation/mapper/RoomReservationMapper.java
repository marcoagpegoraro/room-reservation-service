package com.marvelhospitalitymanagement.room_reservation_service.adapter.out.reservation.mapper;

import com.marvelhospitalitymanagement.room_reservation_service.adapter.out.payment.dto.PaymentServiceResponse;
import com.marvelhospitalitymanagement.room_reservation_service.adapter.out.reservation.RoomReservationJpaEntity;
import com.marvelhospitalitymanagement.room_reservation_service.adapter.out.reservation.RoomReservationJpaRepository;
import com.marvelhospitalitymanagement.room_reservation_service.adapter.out.reservation.dto.RoomReservationDto;
import com.marvelhospitalitymanagement.room_reservation_service.domain.model.PaymentDetails;
import com.marvelhospitalitymanagement.room_reservation_service.usecases.command.RoomReservationConfirmCommand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoomReservationMapper {
    RoomReservationDto commandToDto(RoomReservationConfirmCommand command);
    @Mapping(target = ".", source = "command")
    @Mapping(target = "reservationStatus", source = "reservationStatus")
    RoomReservationJpaEntity commandToJpa(RoomReservationConfirmCommand command, String reservationStatus);
    RoomReservationDto jpaToDto(RoomReservationJpaEntity roomReservationJpaEntity);
    RoomReservationJpaEntity dtoToJpa(RoomReservationDto roomReservationDto);

}
