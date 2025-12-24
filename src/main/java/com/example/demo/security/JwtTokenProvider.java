package com.example.demo.security;

import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;

@Component
public class JwtTokenProvider {

    public String generateToken(Authentication auth, Long userId, String role) {
        return userId + ":" + role;
    }

    public String getUsernameFromToken(String token) {
        return token.split(":")[0];
    }
}
