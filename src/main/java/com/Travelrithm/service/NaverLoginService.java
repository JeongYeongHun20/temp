package com.Travelrithm.service;

import com.Travelrithm.dto.NaverTokenResponseDto;
import com.Travelrithm.dto.NaverUserResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@RequiredArgsConstructor
@Service
public class NaverLoginService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${naver.client_id}")
    private String clientId;

    @Value("${naver.client_secret}")
    private String clientSecret;

    @Value("${naver.redirect_uri}")
    private String redirectUri;

    private final ObjectMapper objectMapper = new ObjectMapper();

    // 네이버 로그인 URL 생성
    public String buildAuthorizeUrl() {
        return UriComponentsBuilder
                .fromHttpUrl("https://nid.naver.com/oauth2.0/authorize")
                .queryParam("response_type", "code")
                .queryParam("client_id", clientId)
                .queryParam("redirect_uri", redirectUri)
                .queryParam("state", "NAVER_RANDOM_STATE") // 실제로는 세션 기반으로 state 관리 추천
                .build()
                .toUriString();
    }

    // 액세스 토큰 요청
    public String getAccessToken(String code, String state) {
        String tokenUrl = UriComponentsBuilder
                .fromHttpUrl("https://nid.naver.com/oauth2.0/token")
                .queryParam("grant_type", "authorization_code")
                .queryParam("client_id", clientId)
                .queryParam("client_secret", clientSecret)
                .queryParam("code", code)
                .queryParam("state", state)
                .build()
                .toUriString();

        ResponseEntity<String> response = restTemplate.getForEntity(tokenUrl, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            try {
                NaverTokenResponseDto tokenResponse = objectMapper.readValue(response.getBody(), NaverTokenResponseDto.class);
                return tokenResponse.access_token();
            } catch (Exception e) {
                throw new RuntimeException("토큰 파싱 실패: " + e.getMessage());
            }
        } else {
            throw new RuntimeException("네이버 토큰 요청 실패: " + response.getBody());
        }
    }

    // 사용자 정보 요청
    public void getUserInfo(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                "https://openapi.naver.com/v1/nid/me",
                HttpMethod.GET,
                entity,
                String.class
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            try {
                NaverUserResponseDto userResponse = objectMapper.readValue(response.getBody(), NaverUserResponseDto.class);
                log.info("Naver user: {}", userResponse);
                // 여기서 회원가입 또는 로그인 처리 로직 추가 가능
            } catch (Exception e) {
                throw new RuntimeException("유저 정보 파싱 실패: " + e.getMessage());
            }
        } else {
            throw new RuntimeException("유저 정보 요청 실패: " + response.getBody());
        }
    }
}
