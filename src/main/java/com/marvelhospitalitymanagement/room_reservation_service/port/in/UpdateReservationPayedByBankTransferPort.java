package com.marvelhospitalitymanagement.room_reservation_service.port.in;

public interface UpdateReservationPayedByBankTransferPort {

    void execute(Long reservationId);

}
