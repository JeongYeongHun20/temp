package com.Travelrithm.domain;


import com.Travelrithm.dto.UserRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="user")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)// Builder로만 접근 가능
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer user_id;
    private String name;
    private String email;
    private String password;
    private String nickname;

    @Enumerated(EnumType.STRING)
    private SocialType social_type;
    private Long social_id;
    private String thumbnail_image_url;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private LocalDateTime nickname_updated_at;

    public void update(UserRequestDto dto) {
        this.name = dto.getName();
        this.password=dto.getPassword();
        this.email = dto.getEmail();
        this.nickname = dto.getNickname();
        this.updated_at = LocalDateTime.now();
    }




}
