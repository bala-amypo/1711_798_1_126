package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "customer_profiles")
@Data // Idhu thaan Getter and Setter-ah auto-ah create pannum
@NoArgsConstructor
@AllArgsConstructor
public class CustomerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerId; // Business ID
    private String name;
    private String email;
    
    // Indha line thaan missing! Idhai kandippa add pannunga
    private String tier; 

    // Oru velai neenga Lombok (@Data) use pannala na, 
    // manual-ah indha setter-ah add pannunga:
    public void setTier(String tier) {
        this.tier = tier;
    }
    
    public String getTier() {
        return this.tier;
    }
}