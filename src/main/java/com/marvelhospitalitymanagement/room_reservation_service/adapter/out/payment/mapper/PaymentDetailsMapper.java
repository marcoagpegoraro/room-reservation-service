package com.marvelhospitalitymanagement.room_reservation_service.adapter.out.payment.mapper;

import com.marvelhospitalitymanagement.room_reservation_service.adapter.in.web.dto.RoomReservationConfirmRequest;
import com.marvelhospitalitymanagement.room_reservation_service.adapter.in.web.dto.RoomReservationConfirmResponse;
import com.marvelhospitalitymanagement.room_reservation_service.adapter.out.payment.dto.PaymentServiceResponse;
import com.marvelhospitalitymanagement.room_reservation_service.domain.model.PaymentDetails;
import com.marvelhospitalitymanagement.room_reservation_service.domain.model.RoomReservationExecuted;
import com.marvelhospitalitymanagement.room_reservation_service.usecases.command.RoomReservationConfirmCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentDetailsMapper {

    PaymentDetails responseToDetails(PaymentServiceResponse roomReservationConfirmRequest);

}
