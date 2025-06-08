package com.quiz.application.repository;

import com.quiz.application.entity.Quiz;
import com.quiz.application.entity.Quiz.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {

    List<Quiz> findByUserUserId(Integer userId);

    List<Quiz> findByUserUserIdAndStatus(Integer userId, Status status);

    long countByUserUserId(Integer userId);
}
