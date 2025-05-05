package com.Travelrithm.dto;

import com.Travelrithm.domain.BusCompanyEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusCompanyRequestDto {
    private String companyName;

    public BusCompanyEntity toEntity() {
        return BusCompanyEntity.builder()
                .companyName(this.companyName)
                .build();
    }
}
