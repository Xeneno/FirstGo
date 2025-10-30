package com.example.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }
    // post request /register 
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        service.register(request); 
        return ResponseEntity.ok("registered"); 
    }

    // /auth/register

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        // String token = service.login(request);
        //return ResponseEntity.ok(new AuthResponse(token));

        service.login(request);
        return ResponseEntity.ok("logged in");
    }
}
