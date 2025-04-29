package com.Travelrithm.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="user")
@Getter
@Setter
public class UserInfo {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer user_id;
    private String name;
    private String email;
    private String password;
    private String nickname;

    @Enumerated(EnumType.STRING)
    private SocialType social_type;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private LocalDateTime nickname_updated_at;




}
