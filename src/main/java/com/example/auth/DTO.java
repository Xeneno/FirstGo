package com.example.demo.auth;

public class RegisterRequest {
    public String email;
    public String password;
}

public class LoginRequest {
    public String email;
    public String password;
}

public class AuthResponse {
    public String token;
    public AuthResponse(String token) { this.token = token; }
}
