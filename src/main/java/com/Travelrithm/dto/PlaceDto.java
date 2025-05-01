package com.Travelrithm.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PlaceDto {
    private Integer placeId;  // 기존 장소라면 ID 포함, 새로 추가되면 null
    private String placeName;
    private String placeAddress;
    private BigDecimal lat;
    private BigDecimal lng;
    private String memo;
    private Integer day;
    private Integer sequence;
    private String category;
}
