package com.Travelrithm.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)//역직렬화 시 dto 객체 필드에 없는 json정보 무시
public record KakaoUserResponseDto(
        Long id,
        Boolean has_signed_up,
        Date connected_at
//      properties, kakao_account, for_partner은 추가적으로 dto 생성해서 받아야함
) { }
