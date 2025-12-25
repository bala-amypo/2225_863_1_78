package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenProvider {
    
    private final String secretKey;
    private final long expirationTime;
    private final Key key;
    
    public JwtTokenProvider() {
        this.secretKey = "VerySecretKeyForJwtDemoApplication123456";
        this.expirationTime = 3600000L;
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }
    
    public JwtTokenProvider(String secretKey, long expirationTime) {
        this.secretKey = secretKey;
        this.expirationTime = expirationTime;
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }
    
    public String generateToken(String username, String role) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + expirationTime);
        
        return Jwts.builder()
            .setSubject(username)
            .claim("role", role)
            .setIssuedAt(now)
            .setExpiration(expiry)
            .signWith(key)
            .compact();
    }
    
    public String generateToken(Authentication auth, Long userId, String role) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + expirationTime);
        
        return Jwts.builder()
            .setSubject(auth.getName())
            .claim("userId", userId)
            .claim("role", role)
            .claim("email", auth.getName())
            .setIssuedAt(now)
            .setExpiration(expiry)
            .signWith(key)
            .compact();
    }
    
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
    
    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
    
    public Map<String, Object> getAllClaims(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        Map<String, Object> result = new HashMap<>();
        result.put("userId", claims.get("userId"));
        result.put("role", claims.get("role"));
        result.put("email", claims.get("email"));
        return result;
    }
}