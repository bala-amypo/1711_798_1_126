package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.repository.UserRepository;

@Service
public class CustomUserDetailsService {

    private final UserRepository repository;

    public CustomUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    public UserRepository getRepository() {
        return repository;
    }
}
