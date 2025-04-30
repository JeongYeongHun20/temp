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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PlanEntity> travelPlans = new ArrayList<>();
    public void update(UserRequestDto dto) {
        this.name = dto.getName();
        this.password=dto.getPassword();
        this.email = dto.getEmail();
        this.nickname = dto.getNickname();
        this.updatedAt = LocalDateTime.now();
    }




}
