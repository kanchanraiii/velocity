package com.velocity.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class GatewayController {

    private final WebClient webClient;

    public GatewayController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/users")
    public String getUsers() {
        return webClient
                .get()
                .uri("http://localhost:8081/users")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}