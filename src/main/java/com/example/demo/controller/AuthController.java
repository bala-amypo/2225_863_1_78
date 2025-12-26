package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.VolunteerProfileService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final VolunteerProfileService volunteerService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(
            VolunteerProfileService volunteerService,
            JwtTokenProvider jwtTokenProvider) {
        this.volunteerService = volunteerService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    // POST /auth/register
    @PostMapping("/register")
    public VolunteerProfile register(@RequestBody RegisterRequest request) {

        VolunteerProfile profile = new VolunteerProfile();
        profile.setVolunteerId(request.getVolunteerId());
        profile.setName(request.getName());
        profile.setEmail(request.getEmail());

        return volunteerService.save(profile);
    }

    // POST /auth/login
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        VolunteerProfile profile =
                volunteerService.get(request.getVolunteerId());

        String token = jwtTokenProvider.generateToken(
                profile.getVolunteerId(),
                "VOLUNTEER"
        );

        return new AuthResponse(
                token,
                profile.getId(),
                "VOLUNTEER"
        );
    }
}
