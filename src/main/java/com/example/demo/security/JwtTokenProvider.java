package com.example.demo.security;

import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;

import java.util.HashMap;
import java.util.Map;

public class JwtTokenProvider {

    private final String secretKey;
    private final long validityInMs;

    public JwtTokenProvider(String secretKey, long validityInMs) {
        this.secretKey = secretKey;
        this.validityInMs = validityInMs;
    }

    public String generateToken(Authentication authentication,
                                Long userId,
                                String role) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);
        claims.put("role", role);
        claims.put("email", authentication.getName());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(authentication.getName())
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        return getAllClaims(token).get("email").toString();
    }

    public Map<String, Object> getAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }
}
