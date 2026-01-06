package com.marvelhospitalitymanagement.room_reservation_service.adapter.out.reservation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomReservationJpaRepository extends JpaRepository<RoomReservationJpaEntity, Long> {
}