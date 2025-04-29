package com.Travelrithm.dto;


import com.Travelrithm.domain.SocialType;
import com.Travelrithm.domain.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class UserResponseDto {
    private Integer userId;
    private String name;
    private String email;
    private String nickname;
    private SocialType socialType;
    private LocalDateTime createdAt;
    private String thumbnail_image_url;

    public UserResponseDto(UserEntity user) {
        this.userId = user.getUser_id();
        this.name = user.getName();
        this.email = user.getEmail();
        this.nickname = user.getNickname();
        this.socialType = user.getSocial_type();
        this.createdAt = user.getCreated_at();
    }
}