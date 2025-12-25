package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    private final VolunteerProfileService volunteerService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    
    public AuthController(VolunteerProfileService volunteerService, 
                         AuthenticationManager authenticationManager,
                         JwtTokenProvider tokenProvider) {
        this.volunteerService = volunteerService;
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
    }
    
    @PostMapping("/register")
    public ResponseEntity<VolunteerProfile> register(@RequestBody RegisterRequest request) {
        VolunteerProfile profile = volunteerService.registerVolunteer(request);
        return ResponseEntity.ok(profile);
    }
    
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        
        String token = tokenProvider.generateToken(request.getEmail(), "USER");
        AuthResponse response = new AuthResponse(token, 1L, "USER");
        return ResponseEntity.ok(response);
    }
}