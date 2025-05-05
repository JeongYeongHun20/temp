package com.Travelrithm.domain;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "scrap")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class ScrapEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer scrapId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne(fetch = FetchType.LAZY) //.getUser 하기전에 객체를 불러오지 않음(지연로딩)
    @JoinColumn(name = "post_id")
    private CommunityPostEntity postEntity;



    private LocalDateTime createdAt;
}
