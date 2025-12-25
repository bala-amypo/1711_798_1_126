package com.example.demo.controller;

import com.example.demo.config.JwtTokenProvider;
import com.example.demo.dto.*;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final JwtTokenProvider tokenProvider;

    public AuthController(UserRepository userRepository,
                          PasswordEncoder encoder,
                          JwtTokenProvider tokenProvider) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest req) {
        User user = new User(
                req.username,
                encoder.encode(req.password),
                req.role
        );
        userRepository.save(user);
        return "User registered";
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest req) {
        User user = userRepository.findByUsername(req.username)
                .orElseThrow();

        if (!encoder.matches(req.password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = tokenProvider.generateToken(user.getUsername());
        return new AuthResponse(token);
    }
}
