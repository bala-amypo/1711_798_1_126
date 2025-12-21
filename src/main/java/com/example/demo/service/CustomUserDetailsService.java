package com.example.demo.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Portal testing-kaga oru hardcoded user (Nee database kooda link pannalam)
        if ("admin".equals(username)) {
            return new User("admin", "{noop}admin123", new ArrayList<>());
        }
        throw new UsernameNotFoundException("User not found");
    }
}