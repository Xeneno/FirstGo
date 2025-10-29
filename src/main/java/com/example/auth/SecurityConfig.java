package com.example.demo.config;

import com.example.demo.auth.AppUserRepository;
import com.example.demo.auth.JwtService;
import com.example.demo.security.JwtAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // 1. Register our filter so it runs on every request
    @Bean
    public FilterRegistrationBean<JwtAuthFilter> jwtFilterRegistration(JwtService jwtService,
                                                                       AppUserRepository repo) {
        FilterRegistrationBean<JwtAuthFilter> reg = new FilterRegistrationBean<>();
        reg.setFilter(new JwtAuthFilter(jwtService, repo));
        reg.addUrlPatterns("/api/*"); // protect /api/*
        reg.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return reg;
    }

    // 2. Spring Security basic setup (disable form login, csrf for API style)
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/auth/**").permitAll()
                    .requestMatchers("/actuator/**").permitAll()
                    .anyRequest().authenticated()
            )
            .httpBasic(httpBasic -> httpBasic.disable())
            .formLogin(form -> form.disable());

        return http.build();
    }
}
