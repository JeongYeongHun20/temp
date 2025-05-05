package com.Travelrithm.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record KakaoTokenResponseDto(
        String token_type,
        String access_token,
        String id_token,
        Integer expires_in,
        String refresh_token,
        Integer refresh_token_expires_in,
        String scope
) {}
