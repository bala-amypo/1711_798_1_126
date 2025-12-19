package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.*;
import com.example.demo.config.JwtTokenProvider;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtTokenProvider jwt;

    public AuthController(JwtTokenProvider jwt) {
        this.jwt = jwt;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        String token = jwt.generateToken(request.username);
        return new AuthResponse(token);
    }
}
