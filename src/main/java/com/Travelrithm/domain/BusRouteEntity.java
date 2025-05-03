package com.Travelrithm.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bus_route")
public class BusRouteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer routeId;

    private String routeName;

    private String departureTime;

    private String arrivalTime;

    private Integer companyId;

    private Integer departureTerminalId;

    private Integer arrivalTerminalId;

    public void update(String routeName, String departureTime, String arrivalTime,
                       Integer companyId, Integer departureTerminalId, Integer arrivalTerminalId) {
        this.routeName = routeName;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.companyId = companyId;
        this.departureTerminalId = departureTerminalId;
        this.arrivalTerminalId = arrivalTerminalId;
    }
}
