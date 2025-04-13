package com.Travelrithm.controller;


import com.Travelrithm.service.KakaoLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@Controller
public class KakaoLoginController {
    private final KakaoLoginService kakaoLoginService;

    @Value("${kakao.client_id}")
    private String client_id;

    @Value("${kakao.redirect_uri}")
    private String redirect_uri;

    @GetMapping("/login/page")
    public String loginPage(Model model) {
        String location = kakaoLoginService.buildAuthorizeUrl();
        model.addAttribute("location", location);
        return "login";
    }

    @ResponseBody
    @GetMapping("/callback")
    public ResponseEntity<?> callback(@RequestParam("code") String code){
        String accessToken = kakaoLoginService.getAccessToken(code);
        kakaoLoginService.getUserInfo(accessToken);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
