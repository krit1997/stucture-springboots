package com.example.service.domain.models.dtos.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Standard API response wrapper")
@Data
public class ApiResponse<T> {
    @Schema(example = "200")
    private String code;

    @Schema(example = "SUCCESS")
    private String status;

    @Schema(description = "Payload data (present on success only)")
    private T data;

    @Schema(description = "Error description (present on error only)", example = "Bad Request")
    private String description;

    // --- factory methods ---
    public static <T> ApiResponse<T> ok(T data) {
        ApiResponse<T> r = new ApiResponse<>();
        r.code = "200";
        r.status = "SUCCESS";
        r.data = data;
        return r;
    }

    public static <T> ApiResponse<T> badRequest(String description) {
        ApiResponse<T> r = new ApiResponse<>();
        r.code = "400";
        r.status = "BAD_REQUEST";
        r.description = description;
        return r;
    }

    public static <T> ApiResponse<T> notFound(String description) {
        ApiResponse<T> r = new ApiResponse<>();
        r.code = "404";
        r.status = "NOT_FOUND";
        r.description = description;
        return r;
    }
}
