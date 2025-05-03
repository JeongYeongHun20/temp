package com.Travelrithm.dto;

import com.Travelrithm.domain.BusReservEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class BusReservResponseDto {
    private Integer reservationId;
    private Integer userId;
    private Integer planId;
    private BusReservEntity.Direction direction;
    private Integer departureTerminalId;
    private Integer arrivalTerminalId;
    private LocalDateTime departureTime;
    private String seatNumber;
    private BusReservEntity.SeatStatus seatStatus;
    private LocalDateTime createdAt;

    public BusReservResponseDto(BusReservEntity entity) {
        this.reservationId = entity.getReservationId();
        this.userId = entity.getUserId();
        this.planId = entity.getPlanId();
        this.direction = entity.getDirection();
        this.departureTerminalId = entity.getDepartureTerminalId();
        this.arrivalTerminalId = entity.getArrivalTerminalId();
        this.departureTime = entity.getDepartureTime();
        this.seatNumber = entity.getSeatNumber();
        this.seatStatus = entity.getSeatStatus();
        this.createdAt = entity.getCreatedAt();
    }
}

