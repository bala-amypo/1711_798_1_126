package com.example.demo.controller;

import com.example.demo.security.JwtTokenProvider;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtTokenProvider tokenProvider;

    public AuthController(JwtTokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> user) {
        // simple test login
        String username = user.get("username");
        String password = user.get("password");
        if ("admin".equals(username) && "admin123".equals(password)) {
            String token = tokenProvider.generateToken(username);
            return Map.of("token", token);
        }
        throw new RuntimeException("Invalid credentials");
    }

    @PostMapping("/register")
    public String register(@RequestBody Map<String, String> user) {
        // simplified registration
        return "User registered: " + user.get("username");
    }
}
