package com.marvelhospitalitymanagement.room_reservation_service.adapter.in.web;

import com.marvelhospitalitymanagement.room_reservation_service.adapter.in.web.dto.RoomReservationConfirmRequest;
import com.marvelhospitalitymanagement.room_reservation_service.adapter.in.web.dto.RoomReservationConfirmResponse;
import com.marvelhospitalitymanagement.room_reservation_service.adapter.in.web.mapper.RoomReservationConfirmMapper;
import com.marvelhospitalitymanagement.room_reservation_service.port.in.ConfirmRoomReservationPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room-reservation")
@RequiredArgsConstructor
public class RoomReservationController {

    private final ConfirmRoomReservationPort confirmRoomReservation;
    private final RoomReservationConfirmMapper roomReservationConfirmMapper;

    @PostMapping("/confirm")
    public ResponseEntity<RoomReservationConfirmResponse> postRoomReservationConfirm(
            @RequestBody @Valid RoomReservationConfirmRequest request
    ){
        final var command = roomReservationConfirmMapper.requestToCommand(request);
        final var executed = confirmRoomReservation.execute(command);
        final var response = roomReservationConfirmMapper.executedToResponse(executed);
        return ResponseEntity.ok(response);
    }
}
