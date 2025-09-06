package com.example.service.models.dtos.request;

import jakarta.validation.constraints.NotBlank;

public record GreetRequest(
        @NotBlank(message = "name is required")
        String name
) {}
