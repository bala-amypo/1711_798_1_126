package com.example.repository;

import com.example.model.User; // Unga User entity peyar vera na adhai mathunga
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<User, Long> {
    
    // Login pannum podhu username database-la irukka nu check panna idhu dhaan help pannum
    Optional<User> findByUsername(String username);
    
    // Oru velai registration feature irundha, username already exist-ah nu check panna:
    Boolean existsByUsername(String username);
}