package com.milena.forumhub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // Desativa o CSRF (caso necessário)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/topicos/**").permitAll() // Permite acesso ao endpoint `/topicos`
                        .anyRequest().authenticated() // Exige autenticação para outros endpoints
                );

        return http.build();
    }
}

