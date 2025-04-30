package com.Travelrithm.dto;


import com.Travelrithm.domain.PlanEntity;
import com.Travelrithm.domain.TransportMode;
import com.Travelrithm.domain.UserEntity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class PlanRequestDto {
    private UserEntity user;
    private String region;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    @Enumerated(EnumType.STRING)
    private TransportMode transportMode;


}
