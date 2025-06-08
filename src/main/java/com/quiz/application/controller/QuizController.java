package com.quiz.application.controller;

import com.quiz.application.dto.QuizResponseDto;
import com.quiz.application.service.QuizService;
import com.quiz.application.util.ResponseUtil;
import com.quiz.application.util.ResponseUtil.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    // Get all quizzes by user ID
    @GetMapping("/quiz")
    public ResponseEntity<ApiResponse<List<QuizResponseDto>>> getQuizzesByUser(
            @RequestParam("userId") Integer userId) {
        List<QuizResponseDto> quizzes = quizService.getQuizzesByUserId(userId);
        return ResponseEntity.ok(ResponseUtil.success(quizzes));
    }
}
