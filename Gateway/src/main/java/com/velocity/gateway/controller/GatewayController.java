package com.velocity.gateway.controller;

import com.velocity.gateway.config.VelocityProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class GatewayController {

    private final WebClient webClient;

    //injecting properties from app.yaml
    private final VelocityProperties properties;

    public GatewayController(WebClient webClient, VelocityProperties velocityProperties) {
        this.webClient = webClient;
        this.properties=velocityProperties;
    }

    @GetMapping("/users")
    public String getUsers() {
        return webClient
                .get()
                .uri(properties.getUserServiceUrl()+"/users")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}