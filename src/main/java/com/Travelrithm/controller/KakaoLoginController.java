package com.Travelrithm.controller;


import com.Travelrithm.dto.KakaoUserResponseDto;
import com.Travelrithm.service.KakaoLoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RequiredArgsConstructor
@Controller
@RequestMapping("/api/kakao")
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class KakaoLoginController {
    private final KakaoLoginService kakaoLoginService;


    @GetMapping("/login")
    public ResponseEntity<Map<String, String>> loginPage(Model model) {
        String location = kakaoLoginService.buildAuthorizeUrl();
        Map<String, String> response = new HashMap<>();
        response.put("location",location);
        return ResponseEntity.ok(response);
    }


    @ResponseBody
    @GetMapping("/callback")
    public ResponseEntity<?> callback(@RequestParam("code") String code){
        String accessToken = kakaoLoginService.getAccessToken(code);
        KakaoUserResponseDto userInfo = kakaoLoginService.getUserInfo(accessToken);
        return new ResponseEntity<>(userInfo.id(), HttpStatus.OK);
    }



}
