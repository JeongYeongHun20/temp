package com.Travelrithm.dto;

import com.Travelrithm.domain.CommunityCommentEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommunityCommentResponseDto {
    private Integer commentId;
    private Integer postId;
    private Integer userId;
    private String commentContent;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CommunityCommentResponseDto(CommunityCommentEntity entity) {
        this.commentId = entity.getCommentId();
        this.postId = entity.getPostId();
        this.userId = entity.getUserId();
        this.commentContent = entity.getCommentContent();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();
    }
}
