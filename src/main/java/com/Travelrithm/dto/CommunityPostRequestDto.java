package com.Travelrithm.dto;

import com.Travelrithm.domain.CommunityPostEntity;
import lombok.*;


public record CommunityPostRequestDto(
        Integer userId,
        String title,
        String postContent,
        Boolean isTravelPlan,
        Integer planId
){}
