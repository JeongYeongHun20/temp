package com.Travelrithm.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "community_post")
public class CommunityPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    private Integer userId;

    private String title;

    @Column(name = "post_content", columnDefinition = "TEXT")
    private String postContent;

    private Boolean isTravelPlan;

    private Integer planId;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public void update(String title, String postContent, Boolean isTravelPlan, Integer planId) {
        this.title = title;
        this.postContent = postContent;
        this.isTravelPlan = isTravelPlan;
        this.planId = planId;
    }
}
