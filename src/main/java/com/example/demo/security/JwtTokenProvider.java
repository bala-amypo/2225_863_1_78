package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public boolean validateToken(String token) {
        return token != null && token.contains(":");
    }

    public String getUsername(String token) {
        return token.split(":")[0];
    }

    public String generateToken(Long userId, String role) {
        return userId + ":" + role;
    }
}
