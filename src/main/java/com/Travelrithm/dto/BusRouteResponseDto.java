package com.Travelrithm.dto;

import com.Travelrithm.domain.BusRouteEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusRouteResponseDto {
    private Integer routeId;
    private String routeName;
    private String departureTime;
    private String arrivalTime;
    private Integer companyId;
    private Integer departureTerminalId;
    private Integer arrivalTerminalId;

    public BusRouteResponseDto(BusRouteEntity entity) {
        this.routeId = entity.getRouteId();
        this.routeName = entity.getRouteName();
        this.departureTime = entity.getDepartureTime();
        this.arrivalTime = entity.getArrivalTime();
        this.companyId = entity.getCompanyId();
        this.departureTerminalId = entity.getDepartureTerminalId();
        this.arrivalTerminalId = entity.getArrivalTerminalId();
    }
}
