package com.example.demo.controller;

import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserModel register(@RequestBody UserModel user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public UserModel login(@RequestBody UserModel user) {
        return userService.loginUser(user.getEmail(), user.getPassword());
    }
}
