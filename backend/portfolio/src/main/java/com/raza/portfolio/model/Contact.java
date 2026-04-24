package com.raza.portfolio.model;

import jakarta.persistence.*;

/**
 * Entity class representing Contact table in database
 */
@Entity
@Table(name = "contacts")
public class Contact {

    // Primary key (auto-generated)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // User name from contact form
    private String name;

    // User email from contact form
    private String email;

    // Message (longer text allowed)
    @Column(length = 1000)
    private String message;

    // Default constructor (required by JPA)
    public Contact() {}

    // Getter for ID
    public Long getId() {
        return id;
    }

    // Getter & Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter & Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter & Setter for message
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}