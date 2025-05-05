package com.Travelrithm.dto;

import com.Travelrithm.domain.CommunityPostEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommunityPostResponseDto {
    private Integer postId;
    private Integer userId;
    private String title;
    private String postContent;
    private Boolean isTravelPlan;
    private Integer planId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CommunityPostResponseDto(CommunityPostEntity entity) {
        this.postId = entity.getPostId();
        this.userId = entity.getUserId();
        this.title = entity.getTitle();
        this.postContent = entity.getPostContent();
        this.isTravelPlan = entity.getIsTravelPlan();
        this.planId = entity.getPlanId();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();
    }
}
