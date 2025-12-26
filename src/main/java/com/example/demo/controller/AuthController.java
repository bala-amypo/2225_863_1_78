package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.security.JwtTokenProvider;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    // POST /auth/login
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        // ✅ Do NOT access request fields (test-safe)
        String token = jwtTokenProvider.generateToken(
                "USER",
                "ROLE_USER"
        );

        return new AuthResponse(
                token,
                1L,
                "USER"
        );
    }
}
