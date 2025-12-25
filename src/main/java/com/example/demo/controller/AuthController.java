package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.security.CustomUserDetailsService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public class AuthController {

    private final CustomUserDetailsService userDetailsService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(CustomUserDetailsService uds,
                          JwtTokenProvider jwt) {
        this.userDetailsService = uds;
        this.jwtTokenProvider = jwt;
    }

    public AuthResponse register(RegisterRequest req) {
        var user = userDetailsService.registerUser(
                req.getName(),
                req.getEmail(),
                req.getPassword(),
                req.getRole()
        );

        Authentication auth =
                new UsernamePasswordAuthenticationToken(
                        req.getEmail(), req.getPassword());

        String token = jwtTokenProvider.generateToken(
                auth,
                (Long) user.get("userId"),
                (String) user.get("role"));

        return new AuthResponse(token);
    }
}
