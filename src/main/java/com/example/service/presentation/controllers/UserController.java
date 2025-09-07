package com.example.service.presentation.controllers;

import com.example.service.domain.models.entities.AppUser;
import com.example.service.infrastructure.repositories.AppUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final AppUserRepository repo;

    @GetMapping
    public List<AppUser> all() {
        return repo.findAll();
    }

    @PostMapping
    public AppUser create(@RequestBody AppUser u) {
        log.info("request >>>>>> {}", u);
        return repo.save(u);
    }
}
