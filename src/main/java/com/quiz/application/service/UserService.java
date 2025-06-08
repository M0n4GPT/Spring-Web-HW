package com.quiz.application.service;

import com.quiz.application.dto.UserRequestDto;
import com.quiz.application.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto userRequest);
    void deleteUser(Integer userId);
    UserResponseDto updateUserStatus(Integer userId, Boolean activate);
    List<UserResponseDto> getAllUsers();
    UserResponseDto getUserById(Integer userId);
}
