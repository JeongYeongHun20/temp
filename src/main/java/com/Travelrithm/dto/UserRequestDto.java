package com.Travelrithm.dto;

import com.Travelrithm.domain.SocialType;
import com.Travelrithm.domain.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserRequestDto {
    private Integer userId;
    private String name;
    private String password;
    private String email;
    private String nickname;
    private SocialType socialType;
    private LocalDateTime createdAt;
    private String thumbnail_image_url;

    public UserRequestDto(UserEntity userEntity) {
        this.userId = userEntity.getUserId();
        this.name = userEntity.getName();
        this.email = userEntity.getEmail();
        this.nickname = userEntity.getNickname();
        this.socialType = userEntity.getSocialType();
        this.createdAt = userEntity.getCreatedAt();
    }
}
