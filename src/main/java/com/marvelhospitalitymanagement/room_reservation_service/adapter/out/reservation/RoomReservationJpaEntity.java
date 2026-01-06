package com.marvelhospitalitymanagement.room_reservation_service.adapter.out.reservation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.OffsetDateTime;

@Entity(name = "room_reservation")
@Getter
@Setter
public class RoomReservationJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomNumber;
    private OffsetDateTime reservationStartDate;
    private OffsetDateTime reservationEndDate;
    private String customerName;
    private String roomSegment;
    private String paymentMode;
    private String paymentReference;
    private String reservationStatus;
    @CreationTimestamp
    private OffsetDateTime createdAt;
    @UpdateTimestamp
    private OffsetDateTime updatedAt;
}