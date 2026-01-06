package com.marvelhospitalitymanagement.room_reservation_service.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoomSegmentEnum {
    SMALL("SMALL"),
    MEDIUM("MEDIUM"),
    LARGE("LARGE"),
    EXTRA_LARGE("EXTRA_LARGE");

    private final String roomSegment;
}
