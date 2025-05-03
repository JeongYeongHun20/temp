package com.Travelrithm.dto;

import com.Travelrithm.domain.CommunityPostEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommunityPostRequestDto {
    private Integer userId;
    private String title;
    private String postContent;
    private Boolean isTravelPlan;
    private Integer planId;

    public CommunityPostEntity toEntity() {
        return CommunityPostEntity.builder()
                .userId(userId)
                .title(title)
                .postContent(postContent)
                .isTravelPlan(isTravelPlan)
                .planId(planId)
                .build();
    }
}
