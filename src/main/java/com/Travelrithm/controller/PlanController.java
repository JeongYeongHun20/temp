package com.Travelrithm.controller;


import com.Travelrithm.domain.PlanEntity;
import com.Travelrithm.domain.UserEntity;
import com.Travelrithm.dto.PlanRequestDto;
import com.Travelrithm.dto.PlanResponseDto;
import com.Travelrithm.security.jwt.CustomUserDetails;
import com.Travelrithm.service.PlanService;
import com.Travelrithm.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/plans")
public class PlanController {
    private final PlanService planService;
    private final UserService userService;
    @GetMapping
    public ResponseEntity<List<PlanResponseDto>> findPlans(@AuthenticationPrincipal CustomUserDetails userDetails) {
        Integer userId=userDetails.getUserId();
        return ResponseEntity.ok(planService.findPlans(userId));
    }

    @PostMapping
    public ResponseEntity<PlanResponseDto> createPlan(@AuthenticationPrincipal CustomUserDetails userDetails, @RequestBody PlanRequestDto planDto){
        Integer userId = userDetails.getUserId();
        return ResponseEntity.ok(planService.createPlan(userId, planDto));


    }
    //검색 기능이니까 PlanName등으로 바꿔야 함
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
