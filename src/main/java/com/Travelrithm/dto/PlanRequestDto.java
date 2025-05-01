package com.Travelrithm.dto;



import com.Travelrithm.domain.TransportMode;
import com.Travelrithm.domain.UserEntity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class PlanRequestDto {
    private Integer userId;
    private String region;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private TransportMode transportMode;
    private List<PlaceDto> placesDto;

}
