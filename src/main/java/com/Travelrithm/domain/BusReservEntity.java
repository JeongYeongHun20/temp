package com.Travelrithm.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "bus_reservation")
public class BusReservEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservationId;
    private Integer userId;
    private Integer planId;

    @Enumerated(EnumType.STRING)
    private Direction direction;
    private Integer arrivalTerminalId;
    private Integer departureTerminalId;
    private LocalDateTime departureTime;
    private String seatNumber;

    @Enumerated(EnumType.STRING)
    private SeatStatus seatStatus;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public enum Direction{
        departure, return_trip
    }

    public enum SeatStatus{
        reserved, cancelled
    }


}
