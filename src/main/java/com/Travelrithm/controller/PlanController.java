package com.Travelrithm.controller;


import com.Travelrithm.domain.PlanEntity;
import com.Travelrithm.dto.PlanRequestDto;
import com.Travelrithm.dto.PlanResponseDto;
import com.Travelrithm.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/plans")
public class PlanController {
    private final PlanService planService;

    @GetMapping
    public ResponseEntity<List<PlanResponseDto>> findPlans(){
        return ResponseEntity.ok(planService.findPlans());
    }

    @PostMapping
    public ResponseEntity<PlanResponseDto> createPlan(@RequestBody PlanRequestDto planDto){
        return ResponseEntity.ok(planService.createPlan(planDto));
    }

    @GetMapping("/{planId}")
    public ResponseEntity<PlanResponseDto> findPlan(@PathVariable(name = "planId") Integer planId) {
        return ResponseEntity.ok(planService.findPlanById(planId));
    }

    @PutMapping("{planId}")
    public ResponseEntity<PlanResponseDto> updatePlan(@PathVariable(name = "planId") Integer planId, @RequestBody PlanRequestDto planDto) {
        return ResponseEntity.ok(planService.updatePlan(planId, planDto));
    }

    @DeleteMapping("/{planId}")
    public ResponseEntity<Void> deletePlan(@PathVariable(name = "planId") Integer planId) {
        planService.deletePlan(planId);
        return ResponseEntity.noContent().build();
    }





}
