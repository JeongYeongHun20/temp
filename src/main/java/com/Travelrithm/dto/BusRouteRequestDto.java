package com.Travelrithm.dto;

import com.Travelrithm.domain.BusRouteEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusRouteRequestDto {
    private String routeName;
    private String departureTime;
    private String arrivalTime;
    private Integer companyId;
    private Integer departureTerminalId;
    private Integer arrivalTerminalId;

    public BusRouteEntity toEntity() {
        return BusRouteEntity.builder()
                .routeName(this.routeName)
                .departureTime(this.departureTime)
                .arrivalTime(this.arrivalTime)
                .companyId(this.companyId)
                .departureTerminalId(this.departureTerminalId)
                .arrivalTerminalId(this.arrivalTerminalId)
                .build();
    }
}
