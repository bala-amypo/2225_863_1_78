package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.exception.BadRequestException;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // POST /auth/register
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {

        if (userService.existsByEmail(request.getEmail())) {
            throw new BadRequestException("Email already exists");
        }

        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // plain text (as per syllabus)
        user.setRole(request.getRole());

        userService.saveUser(user);

        return "User registered successfully";
    }

    // POST /auth/login
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        User user = userService.findByEmail(request.getEmail());

        if (user == null || !user.getPassword().equals(request.getPassword())) {
            throw new BadRequestException("Invalid credentials");
        }

        // Dummy token (enough for test & swagger visibility)
        return new AuthResponse("Login successful", "dummy-token-123");
    }
}
