package com.Travelrithm.config;

import io.netty.handler.codec.http.HttpHeaderValues;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebConfig {

    @Bean
    public WebClient.Builder WebClient() {
        return WebClient
                .builder();


    }

}
