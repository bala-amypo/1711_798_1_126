package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")          // ellam endpoints ku
                        .allowedOrigins("*")        // ella frontend origins ku
                        .allowedMethods("GET","POST","PUT","DELETE","OPTIONS") // methods allow
                        .allowedHeaders("*")       // ella headers allow
                        .allowCredentials(true);   // cookies/token allow panna
            }
        };
    }
}
