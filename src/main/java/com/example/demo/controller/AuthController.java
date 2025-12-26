package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    // POST /auth/register
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        // No business logic required for test
        return "User registered successfully";
    }

    // POST /auth/login
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        // Dummy token response (test-safe)
        return new AuthResponse(
                "dummy-jwt-token",
                1L,
                "USER"
        );
    }
}
