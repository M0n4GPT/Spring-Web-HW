package com.quiz.application.service;

import com.quiz.application.dto.QuizResponseDto;

import java.util.List;

public interface QuizService {
    List<QuizResponseDto> getQuizzesByUserId(Integer userId);
}
