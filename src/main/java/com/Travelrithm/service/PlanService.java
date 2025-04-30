package com.Travelrithm.service;


import com.Travelrithm.domain.PlanEntity;
import com.Travelrithm.dto.PlanRequestDto;
import com.Travelrithm.dto.PlanResponseDto;
import com.Travelrithm.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PlanService {

    private final PlanRepository planRepository;

    public PlanResponseDto createPlan(PlanRequestDto planRequestDto){
        PlanEntity planEntity=PlanEntity.builder()
                .user(planRequestDto.getUser())
                .region(planRequestDto.getRegion())
                .startDate(planRequestDto.getStartDate())
                .endDate(planRequestDto.getEndDate())
                .createdAt(LocalDateTime.now())
                .startTime(planRequestDto.getStartTime())
                .build();
        planRepository.save(planEntity);
        return new PlanResponseDto(planEntity);
    }
    
    //필요 없을것 같지만 혹시 관리자 페이지에서 사용할 수 있을것 같아 넣어놨음
    @Transactional(readOnly = true)
    public PlanResponseDto findPlanById(Integer planId) {
        PlanEntity planEntity = planRepository.findById(planId)
                .orElseThrow(() -> new IllegalArgumentException("해당플랜이 존재하지 않습니다"));
        return new PlanResponseDto(planEntity);
    }

    @Transactional(readOnly = true)
    public List<PlanResponseDto> findPlans(){
        return planRepository.findAll().stream()
                .map(PlanResponseDto::new)
                .toList();
    }

    public PlanResponseDto updatePlan(Integer planId, PlanRequestDto planDto) {
        PlanEntity planEntity = planRepository.findById(planId)
                .orElseThrow(() -> new IllegalArgumentException("해당플랜이 존재하지 않습니다"));
        planEntity.update(planDto);

        return new PlanResponseDto(planEntity);
    }

    public void deletePlan(Integer planId){
        planRepository.deleteById(planId);
    }



}
