package com.anikasystems.casemanagement.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
@SpringBootApplication
public class CaseManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaseManagementApplication.class, args);
	}

	@EnableWebSecurity
	@Configuration
	static class OktaOAuth2WebSecurityConfiguration {
		@Bean
		SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			return http.authorizeHttpRequests(
					(req) -> req.requestMatchers("/**").authenticated()
				)
				.oauth2ResourceServer((srv) -> srv.jwt(Customizer.withDefaults()))
				.cors(Customizer.withDefaults())
				.build();
		}
	}
}
