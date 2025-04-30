package com.Travelrithm.dto;


import com.Travelrithm.domain.SocialType;
import com.Travelrithm.domain.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserResponseDto {
    private Integer userId;
    private String name;
    private String email;
    private String nickname;
    private SocialType socialType;
    private LocalDateTime createdAt;
    private String thumbnail_image_url;

    public UserResponseDto(UserEntity userEntity) {
        this.userId = userEntity.getUserId();
        this.name = userEntity.getName();
        this.email = userEntity.getEmail();
        this.nickname = userEntity.getNickname();
        this.socialType = userEntity.getSocialType();
        this.createdAt = userEntity.getCreatedAt();
        this.thumbnail_image_url = userEntity.getThumbnailImageUrl();
    }
}