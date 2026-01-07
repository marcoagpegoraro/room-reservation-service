package com.marvelhospitalitymanagement.room_reservation_service.adapter.in.web.config;

import com.marvelhospitalitymanagement.room_reservation_service.adapter.in.web.dto.ErrorResponse;
import com.marvelhospitalitymanagement.room_reservation_service.domain.exceptions.*;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IntegrationException.class)
    public ResponseEntity<ErrorResponse> handleIntegrationException(IntegrationException ex) {
        final var  errorResponse = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(InvalidPaymentException.class)
    public ResponseEntity<ErrorResponse> handleException(InvalidPaymentException ex) {
        final var  errorResponse = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidRoomConfirmationException.class)
    public ResponseEntity<ErrorResponse> handleException(InvalidRoomConfirmationException ex) {
        final var  errorResponse = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PaymentNotConfirmedException.class)
    public ResponseEntity<ErrorResponse> handleException(PaymentNotConfirmedException ex) {
        final var  errorResponse = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.PAYMENT_REQUIRED);
    }
    @ExceptionHandler(ReservationNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(ReservationNotFoundException ex) {
        final var  errorResponse = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        final var errorResponse = new ErrorResponse(ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + " "  + error.getDefaultMessage())
                .collect(Collectors.joining(". ")) + ".");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
