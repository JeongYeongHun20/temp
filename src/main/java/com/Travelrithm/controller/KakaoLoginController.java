package com.Travelrithm.controller;


import com.Travelrithm.dto.KakaoUserResponseDto;
import com.Travelrithm.dto.UserResponseDto;
import com.Travelrithm.service.KakaoLoginService;
import com.Travelrithm.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/kakao")
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class KakaoLoginController {
    private final KakaoLoginService kakaoLoginService;
    private final UserService userService;

    @GetMapping("/login")
    public ResponseEntity<Map<String, String>> loginPage() {
        String location = kakaoLoginService.buildAuthorizeUrl();
        Map<String, String> response = new HashMap<>();
        response.put("location",location);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/callback")
    public ResponseEntity<UserResponseDto> callback(@RequestParam("code") String code){
        String accessToken = kakaoLoginService.getAccessToken(code);
        KakaoUserResponseDto userInfo = kakaoLoginService.getUserInfo(accessToken);
        UserResponseDto userDto = userService.join(userInfo);
        return ResponseEntity.ok(userDto);
    }



}
