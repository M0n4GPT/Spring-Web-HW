package com.quiz.application.dto;

import java.sql.Timestamp;

public class UserResponseDto {

    private Integer userId;
    private String email;
    private String firstname;
    private String lastname;
    private Boolean isActive;
    private Boolean isAdmin;
    private Timestamp createdAt;

    public UserResponseDto() {}

    public UserResponseDto(Integer userId, String email, String firstname, String lastname,
                           Boolean isActive, Boolean isAdmin, Timestamp createdAt) {
        this.userId = userId;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.isActive = isActive;
        this.isAdmin = isAdmin;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
