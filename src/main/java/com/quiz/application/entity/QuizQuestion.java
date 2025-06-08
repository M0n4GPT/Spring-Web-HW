package com.quiz.application.entity;

import javax.persistence.*;

@Entity
@Table(name = "QuizQuestion")
public class QuizQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer qqId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_choice_id")
    private Choice userChoice;

    private Boolean isCorrect;

    public QuizQuestion() {}

    public QuizQuestion(Quiz quiz, Question question) {
        this.quiz = quiz;
        this.question = question;
    }

    // Getters and Setters
}
