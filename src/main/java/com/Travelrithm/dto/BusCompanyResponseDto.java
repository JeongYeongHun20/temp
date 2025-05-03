package com.Travelrithm.dto;

import com.Travelrithm.domain.BusCompanyEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusCompanyResponseDto {
    private Integer companyId;
    private String companyName;

    public BusCompanyResponseDto(BusCompanyEntity entity) {
        this.companyId = entity.getCompanyId();
        this.companyName = entity.getCompanyName();
    }
}
