package com.Travelrithm.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bus_schedule")
public class BusScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer scheduleId;

    private Integer routeId;

    private LocalDateTime departureTime;

    private Integer availableSeats;

    public void update(Integer routeId, LocalDateTime departureTime, Integer availableSeats) {
        this.routeId = routeId;
        this.departureTime = departureTime;
        this.availableSeats = availableSeats;
    }
}
