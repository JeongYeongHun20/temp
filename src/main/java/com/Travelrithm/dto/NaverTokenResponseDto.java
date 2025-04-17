package com.Travelrithm.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record NaverTokenResponseDto(
        String access_token,
        String refresh_token,
        String token_type,
        String expires_in,
        String error,
        String error_description
) {}
