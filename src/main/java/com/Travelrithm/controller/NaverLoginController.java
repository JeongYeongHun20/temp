package com.Travelrithm.controller;

import com.Travelrithm.dto.NaverUserResponseDto;
import com.Travelrithm.service.NaverLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/naver")
@CrossOrigin(origins = "http://localhost:3000")
public class NaverLoginController {
    private final NaverLoginService naverLoginService;

    @GetMapping("/login")
    @ResponseBody
    public ResponseEntity<Map<String, String>> loginPage() {
        String naverLocation = naverLoginService.buildAuthorizeUrl();
        Map<String, String> response = new HashMap<>();
        response.put("naverLocation", naverLocation);
        return ResponseEntity.ok(response);
    }

    @ResponseBody
    @GetMapping("/callback")
    public ResponseEntity<?> callback(@RequestParam("code") String code,
                                      @RequestParam("state") String state) {
        String accessToken = naverLoginService.getAccessToken(code);
        NaverUserResponseDto userInfo = naverLoginService.getUserInfo(accessToken);
        return new ResponseEntity<>(userInfo, HttpStatus.OK);
    }
}

