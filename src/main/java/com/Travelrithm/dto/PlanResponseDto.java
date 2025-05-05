package com.Travelrithm.dto;


import com.Travelrithm.domain.PlanEntity;



import java.time.LocalDate;


public record PlanResponseDto(
        Integer planId,
        String region,
        LocalDate startDate,
        LocalDate endDate
) {
    public PlanResponseDto(PlanEntity planEntity){
        this(
                planEntity.getPlanId(),
                planEntity.getRegion(),
                planEntity.getStartDate(),
                planEntity.getEndDate()
        );
    }
}
