package com.Travelrithm.controller;

import com.Travelrithm.service.NaverLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/naver")
public class NaverLoginController {

    private final NaverLoginService naverLoginService;

    @Value("${naver.client_id}")
    private String clientId;

    @Value("${naver.redirect_uri}")
    private String redirectUri;

    @GetMapping("/login")
    public String loginPage(Model model) {
        String location = naverLoginService.buildAuthorizeUrl();
        model.addAttribute("location", location);
        return "login";
    }

    @ResponseBody
    @GetMapping("/callback")
    public ResponseEntity<?> callback(@RequestParam("code") String code,
                                      @RequestParam("state") String state) {
        String accessToken = naverLoginService.getAccessToken(code, state);
        naverLoginService.getUserInfo(accessToken);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
