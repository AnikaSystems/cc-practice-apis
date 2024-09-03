package com.anikasystems.casemanagement.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.annotation.PostConstruct;

@Configuration
public class WebConfig {

    @Value("${cors.allowed.origin}")
    private String allowedOrigin;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                System.out.println("Configuring CORS with allowed origins: " + allowedOrigin);
                registry.addMapping("/**")
                        .allowedOrigins(allowedOrigin.split(","))
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS");
            }
        };
    }

    @PostConstruct
    public void init() {
        // This method will be called after the bean initialization
        System.out.println("Allowed CORS Origins: " + allowedOrigin);
    }
}