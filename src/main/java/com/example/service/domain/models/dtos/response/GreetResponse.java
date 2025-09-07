package com.example.service.domain.models.dtos.response;

import java.time.Instant;

public record GreetResponse(
        String message,
        Instant serverTime
) {
}
