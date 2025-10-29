package com.example.demo.security;

import com.example.demo.auth.AppUserRepository;
import com.example.demo.auth.JwtService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import java.io.IOException;
import java.util.List;

public class JwtAuthFilter implements Filter {

    private final JwtService jwtService;
    private final AppUserRepository repo;

    public JwtAuthFilter(JwtService jwtService, AppUserRepository repo) {
        this.jwtService = jwtService;
        this.repo = repo;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest http = (HttpServletRequest) request;
        String authHeader = http.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring("Bearer ".length());

            try {
                Claims claims = jwtService.parseToken(token);
                String email = claims.getSubject();

                var user = repo.findByEmail(email);
                if (user.isPresent()) {
                    var auth = new UsernamePasswordAuthenticationToken(
                            email,
                            null,
                            List.of() // you could map roles here
                    );
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            } catch (Exception e) {
                ((HttpServletResponse) response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }

        chain.doFilter(request, response);
    }
}
