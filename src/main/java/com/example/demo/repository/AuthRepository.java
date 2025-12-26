/*package com.example.demo.repository;

import com.example.demo.model.CustomerProfile; // User-ku badhula CustomerProfile
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<CustomerProfile, Long> {
    
    // Inga email illa na username - unga CustomerProfile-la entha field login-ku irukko adha use pannunga
    Optional<CustomerProfile> findByEmail(String email); 
}*/