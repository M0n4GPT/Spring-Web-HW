package com.quiz.application.service;

import com.quiz.application.dto.QuizResponseDto;
import com.quiz.application.entity.Quiz;
import com.quiz.application.entity.User;
import com.quiz.application.exception.UserNotFoundException;
import com.quiz.application.repository.QuizRepository;
import com.quiz.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final UserRepository userRepository;

    @Autowired
    public QuizServiceImpl(QuizRepository quizRepository, UserRepository userRepository) {
        this.quizRepository = quizRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<QuizResponseDto> getQuizzesByUserId(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + userId));
        List<Quiz> quizzes = quizRepository.findByUserUserId(userId);
        return quizzes.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private QuizResponseDto mapToDto(Quiz quiz) {
        return new QuizResponseDto(
                quiz.getQuizId(),
                quiz.getUser().getUserId(),
                quiz.getCategory().getCategoryId(),
                quiz.getName(),
                quiz.getTimeStart(),
                quiz.getTimeEnd(),
                quiz.getStatus(),
                quiz.getScore(),
                quiz.getTotalQuestions()
        );
    }
}
