package com.Travelrithm.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record NaverUserResponseDto(
        String resultcode,
        String message,
        Response response
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Response(
            String id,
            String name,
            String email,
            String nickname
    ) {}
}
