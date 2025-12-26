package com.example.demo.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // simple in-memory user for testing
        return User.builder()
                .username("admin")
                .password("{noop}admin123") // no encoding for test
                .roles("ADMIN")
                .build();
    }
}
