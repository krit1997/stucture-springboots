package com.example.service.models.dtos.response;

import java.time.Instant;

public record GreetResponse(
        String message,
        Instant serverTime
) {
}
