package com.Travelrithm.dto;

import com.Travelrithm.domain.LikeEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LikeRequestDto {

    private Integer userId;
    private Integer postId;
    private Integer planId;

    public LikeEntity toEntity() {
        return LikeEntity.builder()
                .userId(userId)
                .postId(postId)
                .planId(planId)
                .build();
    }
}

