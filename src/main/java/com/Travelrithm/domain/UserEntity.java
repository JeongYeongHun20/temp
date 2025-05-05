package com.Travelrithm.domain;


import com.Travelrithm.dto.UserRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)// Builder로만 접근 가능
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer userId;
    private String name;
    private String email;
    private String password;
    private String nickname;


    @Enumerated(EnumType.STRING)
    private SocialType socialType;
    private Long socialId;
    private String thumbnailImageUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime nicknameUpdatedAt;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<PlanEntity> planEntities = new ArrayList<>();

    public void update(UserRequestDto dto) {
        this.name = dto.name();
        this.password=dto.password();
        this.email = dto.email();
        this.nickname = dto.nickname();
        this.updatedAt = LocalDateTime.now();
    }




}
