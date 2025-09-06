package com.example.service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
public class HelloController {

    record HelloResponse(String message, Instant serverTime) {}

    @GetMapping("/api/v1/hello")
    public HelloResponse hello() {
        return new HelloResponse("Hello from Spring Boot 👋", Instant.now());
    }
}
