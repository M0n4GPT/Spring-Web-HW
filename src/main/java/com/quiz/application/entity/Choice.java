package com.quiz.application.entity;

import javax.persistence.*;

@Entity
@Table(name = "Choice")
public class Choice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer choiceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean isCorrect = false;

    public Choice() {}

    public Choice(Question question, String description, Boolean isCorrect) {
        this.question = question;
        this.description = description;
        this.isCorrect = isCorrect;
    }

    // Getters and Setters
}
