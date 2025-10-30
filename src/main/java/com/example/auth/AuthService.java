package com.example.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AppUserRepository repo;
    private final PasswordEncoder passwordEncoder;
   /// private final JwtService jwtService;

    public AuthService(AppUserRepository repo,
                       PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
        //this.jwtService = jwtService;
    }

    public void register(RegisterRequest request) {
        AppUser u = new AppUser(); 
        u.setEmail(request.email);
        u.setPasswordHash(passwordEncoder.encode(request.password));
    
        repo.save(u);
    }

    public void login(LoginRequest request) {
        AppUser u = repo.findByEmail(request.email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.password, u.getPasswordHash())) {
            throw new RuntimeException("Bad credentials");
        }

        
        // return jwtService.generateToken(u);
    }
}
