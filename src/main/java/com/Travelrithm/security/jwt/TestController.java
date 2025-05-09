package com.Travelrithm.security.jwt;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping
    public String testc() {
        return "mainController";
    }
    @GetMapping("/admin")
    public String testadmin() {
        return "adminController";
    }
}
