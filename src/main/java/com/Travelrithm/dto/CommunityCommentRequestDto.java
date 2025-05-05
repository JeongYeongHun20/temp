package com.Travelrithm.dto;

import com.Travelrithm.domain.CommunityCommentEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommunityCommentRequestDto {
    private Integer postId;
    private Integer userId;
    private String commentContent;

    public CommunityCommentEntity toEntity() {
        return CommunityCommentEntity.builder()
                .postId(postId)
                .userId(userId)
                .commentContent(commentContent)
                .build();
    }
}
