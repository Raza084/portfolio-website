package com.raza.portfolio.controller;

import com.raza.portfolio.model.Contact;
import com.raza.portfolio.repository.ContactRepository;
import com.raza.portfolio.service.EmailService;

import org.springframework.web.bind.annotation.*;

/**
 * Controller class to handle contact form requests
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Allows requests from frontend
public class ContactController {

    // Repository to interact with database
    private final ContactRepository contactRepository;

    // Service to handle email sending
    private final EmailService emailService;

    /**
     * Constructor Injection (recommended approach)
     */
    public ContactController(ContactRepository contactRepository, EmailService emailService) {
        this.contactRepository = contactRepository;
        this.emailService = emailService;
    }

    /**
     * API to handle contact form submission
     * URL: POST /api/contact
     */
    @PostMapping("/contact")
    public String saveContact(@RequestBody Contact contact) {

        // Save contact data to database
        contactRepository.save(contact);

        // Send email notification
        emailService.sendEmail(
                contact.getName(),
                contact.getEmail(),
                contact.getMessage()
        );

        // Return response to frontend
        return "Message sent successfully!";
    }
}