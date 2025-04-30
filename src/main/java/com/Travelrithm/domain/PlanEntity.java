package com.Travelrithm.domain;


import com.Travelrithm.dto.PlanRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


import lombok.*;
import java.time.*;

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
    private UserEntity user;

    private String region;

    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    @Enumerated(EnumType.STRING)
    private TransportMode transportMode;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;



    public void update(PlanRequestDto planDto) {
        this.region = planDto.getRegion();
        this.startDate = planDto.getStartDate();
        this.endDate = planDto.getEndDate();
        this.transportMode = planDto.getTransportMode();
        this.startTime = planDto.getStartTime();
        this.updatedAt = LocalDateTime.now();


    }
}


