package com.raza.portfolio.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Service class responsible for sending emails
 */
@Service
public class EmailService {

    // JavaMailSender is used to send emails via SMTP
    private final JavaMailSender mailSender;

    /**
     * Constructor Injection (recommended)
     */
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    /**
     * Method to send email when contact form is submitted
     */
    public void sendEmail(String name, String email, String message) {

        // Create email object
        SimpleMailMessage mail = new SimpleMailMessage();

        // Receiver email (your email)
        mail.setTo("naeemndambal@gmail.com");

        // Subject of email
        mail.setSubject("New Contact Message from Portfolio");

        // Email body
        mail.setText(
                "Name: " + name +
                "\nEmail: " + email +
                "\nMessage: " + message
        );

        // Send email
        mailSender.send(mail);
    }
}