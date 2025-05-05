package com.Travelrithm.dto;



import com.Travelrithm.domain.TransportMode;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public record PlanRequestDto(
        Integer userId,
        String region,
        LocalDate startDate,
        LocalDate endDate,
        LocalTime startTime,
        TransportMode transportMode,
        List<PlaceDto> placesDto
) {}
