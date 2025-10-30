package com.example.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    // JPA Repository allows us to do sql queries directly using method names


    Optional<AppUser> findByEmail(String email);

}
