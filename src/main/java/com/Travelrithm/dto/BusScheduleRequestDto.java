package com.Travelrithm.dto;

import com.Travelrithm.domain.BusScheduleEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusScheduleRequestDto {
    private Integer routeId;
    private LocalDateTime departureTime;
    private Integer availableSeats;

    public BusScheduleEntity toEntity() {
        return BusScheduleEntity.builder()
                .routeId(this.routeId)
                .departureTime(this.departureTime)
                .availableSeats(this.availableSeats)
                .build();
    }
}
