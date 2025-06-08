package com.quiz.application.dto;

import com.quiz.application.entity.Quiz.Status;

import java.sql.Timestamp;

public class QuizResponseDto {

    private Integer quizId;
    private Integer userId;
    private Integer categoryId;
    private String name;
    private Timestamp timeStart;
    private Timestamp timeEnd;
    private Status status;
    private Integer score;
    private Integer totalQuestions;

    public QuizResponseDto() {}

    public QuizResponseDto(Integer quizId, Integer userId, Integer categoryId, String name,
                           Timestamp timeStart, Timestamp timeEnd, Status status,
                           Integer score, Integer totalQuestions) {
        this.quizId = quizId;
        this.userId = userId;
        this.categoryId = categoryId;
        this.name = name;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.status = status;
        this.score = score;
        this.totalQuestions = totalQuestions;
    }

    // Getters and Setters
    public Integer getQuizId() {
        return quizId;
    }

    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Timestamp timeStart) {
        this.timeStart = timeStart;
    }

    public Timestamp getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Timestamp timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(Integer totalQuestions) {
        this.totalQuestions = totalQuestions;
    }
}
