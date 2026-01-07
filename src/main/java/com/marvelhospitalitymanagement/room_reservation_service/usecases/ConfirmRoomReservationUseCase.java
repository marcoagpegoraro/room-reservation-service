package com.marvelhospitalitymanagement.room_reservation_service.usecases;

import com.marvelhospitalitymanagement.room_reservation_service.domain.model.RoomReservationExecuted;
import com.marvelhospitalitymanagement.room_reservation_service.port.in.ConfirmRoomReservationPort;
import com.marvelhospitalitymanagement.room_reservation_service.domain.model.RoomReservationConfirmCommand;
import com.marvelhospitalitymanagement.room_reservation_service.usecases.strategy.PaymentFactory;
import com.marvelhospitalitymanagement.room_reservation_service.usecases.strategy.PaymentStrategy;
import com.marvelhospitalitymanagement.room_reservation_service.usecases.validators.RoomReservationConfirmValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ConfirmRoomReservationUseCase implements ConfirmRoomReservationPort {

    /*
        It is a list of beans that implements the validator interface, if in the future
        the application should require more validators, the only thing that the developer needs
        to do is create another spring component that implements the interface
     */
    private final List<RoomReservationConfirmValidator> validators;
    private final PaymentFactory paymentFactory;

    @Override
    public RoomReservationExecuted execute(RoomReservationConfirmCommand command) {
        validators.forEach(validator -> validator.validate(command));
        PaymentStrategy paymentStrategy = paymentFactory.get(command.paymentMode().getPaymentMode());
        return paymentStrategy.execute(command);
    }
}
