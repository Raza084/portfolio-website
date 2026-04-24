package com.raza.portfolio.repository;

import com.raza.portfolio.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Contact entity
 * Provides built-in CRUD operations (save, findAll, delete, etc.)
 */
public interface ContactRepository extends JpaRepository<Contact, Long> {

    // No need to write methods manually
    // JpaRepository provides all basic database operations

}