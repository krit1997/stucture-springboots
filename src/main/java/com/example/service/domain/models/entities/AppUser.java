package com.example.service.domain.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;

@Entity
@Table(name = "app_user")
@Data
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    private String email;

    private String name;

    @Column(name="status", nullable=false)
    private String status;

    @Column(name="created_at", columnDefinition = "timestamptz")
    private OffsetDateTime createdAt;
}
