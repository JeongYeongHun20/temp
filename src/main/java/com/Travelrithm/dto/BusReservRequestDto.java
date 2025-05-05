package com.Travelrithm.dto;

import com.Travelrithm.domain.BusReservEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BusReservRequestDto {
    private Integer userId;
    private Integer planId;
    private BusReservEntity.Direction direction;
    private Integer departureTerminalId;
    private Integer arrivalTerminalId;
    private LocalDateTime departureTime;
    private String seatNumber;
    // seatStatus는 예약 생성 시 기본값으로 처리할 수 있으므로 요청 dto에서는 생략할 수도 있습니다.
}

