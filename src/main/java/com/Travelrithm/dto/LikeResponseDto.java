package com.Travelrithm.dto;

import com.Travelrithm.domain.LikeEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LikeResponseDto {

    private Integer likeId;
    private Integer userId;
    private Integer postId;
    private Integer planId;
    private LocalDateTime createdAt;

    public LikeResponseDto(LikeEntity entity) {
        this.likeId = entity.getLikeId();
        this.userId = entity.getUserId();
        this.postId = entity.getPostId();
        this.planId = entity.getPlanId();
        this.createdAt = entity.getCreatedAt();
    }
}
