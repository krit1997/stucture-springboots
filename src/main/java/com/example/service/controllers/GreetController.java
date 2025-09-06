package com.example.service.controllers;

import com.example.service.models.dtos.request.GreetRequest;
import com.example.service.models.dtos.response.GreetResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("greet")
@Tag(name = "Greet", description = "Greeting endpoints")
public class GreetController {

    @Operation(
            summary = "Say hello",
            description = "Return greeting message with server time",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = GreetResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Bad Request",
                            content = @Content)
            }
    )
    @GetMapping
    public GreetResponse hello(
            @Parameter(description = "Optional name. If missing, defaults to \"Guest\"")
            @RequestParam(required = false) String name
    ) {
        String who = (name == null || name.isBlank()) ? "Guest" : name.trim();
        return new GreetResponse("Hello " + who + " 👋", Instant.now());
    }

    @Operation(
            summary = "Say hello (POST)",
            description = "Greeting using JSON body with validation"
    )
    @PostMapping()
    public GreetResponse helloPost(@Valid @RequestBody GreetRequest request) {
        return new GreetResponse("Hello " + request.name() + " 👋", Instant.now());
    }
}
