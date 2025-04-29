package com.Travelrithm.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)//역직렬화 시 dto 객체 필드에 없는 json정보 무시
public record KakaoUserResponseDto(
        Long id,
        Boolean has_signed_up,
        Date connected_at,
        KakaoAccount kakao_account
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record KakaoAccount(
        String email,
        String name,
        Profile profile
    ){
        @JsonIgnoreProperties(ignoreUnknown = true)
        public record Profile(
            String nickname,
            String thumbnail_image_url,
            String profile_image_url
        ){}

    }


}
