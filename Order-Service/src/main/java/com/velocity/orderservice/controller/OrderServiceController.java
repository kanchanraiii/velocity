package com.velocity.orderservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderServiceController {

    @GetMapping
    public List<Integer> getOrder(){
        return List.of(5,10,15);
    }
}
