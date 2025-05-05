package com.Travelrithm.domain;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "travel_place")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class PlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer placeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id", nullable = false)
    private PlanEntity planEntity;

    private String placeName;
    private String placeAddress;
    private BigDecimal lat;
    private BigDecimal lng;
    private String memo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer day;
    private Integer sequence;
    private String category;


}