package com.Travelrithm.domain;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "community_post")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @OneToMany(mappedBy = "postEntity", cascade = CascadeType.ALL)
    private List<ScrapEntity> scrapEntities;

    private String title;

    private String postContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id")
    private PlanEntity planEntity;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Boolean isTravelPlan;

}
