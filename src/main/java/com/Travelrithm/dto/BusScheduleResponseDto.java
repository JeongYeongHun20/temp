package com.Travelrithm.dto;

import com.Travelrithm.domain.BusScheduleEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusScheduleResponseDto {
    private Integer scheduleId;
    private Integer routeId;
    private LocalDateTime departureTime;
    private Integer availableSeats;

    public BusScheduleResponseDto(BusScheduleEntity entity) {
        this.scheduleId = entity.getScheduleId();
        this.routeId = entity.getRouteId();
        this.departureTime = entity.getDepartureTime();
        this.availableSeats = entity.getAvailableSeats();
    }
}
