package com.quiz.application.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contactId;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, insertable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp time;

    @Column(nullable = false)
    private Boolean isRead = false;

    public Contact() {}

    public Contact(String subject, String message, String email) {
        this.subject = subject;
        this.message = message;
        this.email = email;
    }

    // Getters and Setters
}
