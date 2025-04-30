package com.Travelrithm.dto;


import com.Travelrithm.domain.PlanEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PlanResponseDto {
    private Integer planId;
    private String region;
    private LocalDate startDate;
    private LocalDate endDate;

    public PlanResponseDto(PlanEntity planEntity){
        this.planId = planEntity.getPlanId();
        this.region = planEntity.getRegion();
        this.startDate = planEntity.getStartDate();
        this.endDate = planEntity.getEndDate();
    }
}
