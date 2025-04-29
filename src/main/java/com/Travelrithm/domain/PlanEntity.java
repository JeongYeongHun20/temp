package com.Travelrithm.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "travel_plan")
@Getter
@Setter
public class PlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer plan_id;

    private Integer user_id;
    private String region;
    private LocalDate start_date;
    private LocalDate end_date;

    @Enumerated(EnumType.STRING)
    private TransportMode transportMode;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private LocalTime start_time;

}
