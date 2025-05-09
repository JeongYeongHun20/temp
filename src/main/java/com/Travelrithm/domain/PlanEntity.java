package com.Travelrithm.domain;


import com.Travelrithm.dto.PlaceDto;
import com.Travelrithm.dto.PlanRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


import lombok.*;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "travel_plan")
public class PlanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer planId;

    @ManyToOne(fetch = FetchType.LAZY) //.getUser 하기전에 객체를 불러오지 않음(지연로딩)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    private String region;

    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    @Enumerated(EnumType.STRING)
    private TransportMode transportMode;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "planEntity", cascade = CascadeType.ALL)
    @Builder.Default
    private List<PlaceEntity> placeEntities = new ArrayList<>();

    @OneToMany(mappedBy = "planEntity", cascade = CascadeType.ALL)
    @Builder.Default
    private List<CommunityPostEntity> postEntities = new ArrayList<>();

    public void update(PlanRequestDto planDto) {

        this.region = planDto.region();
        this.startDate = planDto.startDate();
        this.endDate = planDto.endDate();
        this.transportMode = planDto.transportMode();
        this.startTime = planDto.startTime();
        this.updatedAt = LocalDateTime.now();

    }

}


