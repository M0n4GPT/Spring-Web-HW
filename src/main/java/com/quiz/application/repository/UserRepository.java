package com.quiz.application.repository;

import com.quiz.application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    List<User> findByIsActive(Boolean isActive);

    boolean existsByEmail(String email);
}
