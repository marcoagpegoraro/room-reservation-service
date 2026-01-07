package com.marvelhospitalitymanagement.room_reservation_service.adapter.in.web.mapper;

import com.marvelhospitalitymanagement.room_reservation_service.adapter.in.web.dto.RoomReservationConfirmRequest;
import com.marvelhospitalitymanagement.room_reservation_service.adapter.in.web.dto.RoomReservationConfirmResponse;
import com.marvelhospitalitymanagement.room_reservation_service.domain.model.RoomReservationExecuted;
import com.marvelhospitalitymanagement.room_reservation_service.domain.model.RoomReservationConfirmCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomReservationConfirmMapper {

    RoomReservationConfirmCommand requestToCommand(RoomReservationConfirmRequest roomReservationConfirmRequest);
    RoomReservationConfirmResponse executedToResponse(RoomReservationExecuted roomReservationExecuted);

}
