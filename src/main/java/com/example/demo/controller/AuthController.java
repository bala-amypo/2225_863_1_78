package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.security.CustomUserDetailsService;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public class AuthController {

    private final CustomUserDetailsService userDetailsService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(CustomUserDetailsService uds,
                          JwtTokenProvider jwtTokenProvider) {
        this.userDetailsService = uds;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public AuthResponse register(RegisterRequest request) {

        var user = userDetailsService.registerUser(
                request.getName(),
                request.getEmail(),
                request.getPassword(),
                request.getRole()
        );

        Authentication auth =
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                );

        String token = jwtTokenProvider.generateToken(
                auth,
                (Long) user.get("userId"),
                (String) user.get("role")
        );

        return new AuthResponse(token);
    }
}
