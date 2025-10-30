package com.example.Business;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository layer for managing AppService entities.
 * 
 * This interface extends JpaRepository, giving you built-in CRUD methods:
 *  - save() to insert or update a service
 *  - findAll() to list all services
 *  - findById() to get one by ID
 *  - deleteById() to remove a record
 * 
 * Spring Data JPA will automatically implement this interface at runtime.
 */

@Repository
public interface AppBusinessRepository extends JpaRepository<AppBusiness, Long> {
    
    List<AppBusiness> findByServiceType(String serviceType);

    // You can also define custom queries here if needed (e.g., findByServiceType)
}
