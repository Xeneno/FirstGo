package com.example.auth;

import jakarta.persistence.*;

@Entity
@Table(name = "users") 
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, name = "password_hash")
    private String passwordHash;

    @Column(nullable = false)
    private String role = "USER";

    @Column(nullable = false, unique = true)
    private String number;

    // getters & setters
    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getPasswordHash() { return passwordHash; }
    public String getRole() { return role; }
    public String getNumber() { return number; }
    

    public void setId(Long id) { this.id = id; }
    public void setEmail(String email) { this.email = email; }
    public void setNumber(String number) { this.number = number; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public void setRole(String role) { this.role = role; }
}
