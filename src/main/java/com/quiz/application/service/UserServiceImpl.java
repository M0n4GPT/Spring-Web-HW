package com.quiz.application.service;

import com.quiz.application.dto.UserRequestDto;
import com.quiz.application.dto.UserResponseDto;
import com.quiz.application.entity.User;
import com.quiz.application.exception.UserNotFoundException;
import com.quiz.application.exception.ValidationException;
import com.quiz.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequest) {
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            throw new ValidationException("Email already in use.");
        }
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setFirstname(userRequest.getFirstname());
        user.setLastname(userRequest.getLastname());
        user = userRepository.save(user);
        return mapToDto(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + userId));
        userRepository.delete(user);
    }

    @Override
    public UserResponseDto updateUserStatus(Integer userId, Boolean activate) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + userId));
        user.setIsActive(activate);
        user = userRepository.save(user);
        return mapToDto(user);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto getUserById(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + userId));
        return mapToDto(user);
    }

    private UserResponseDto mapToDto(User user) {
        return new UserResponseDto(
                user.getUserId(),
                user.getEmail(),
                user.getFirstname(),
                user.getLastname(),
                user.getIsActive(),
                user.getIsAdmin(),
                user.getCreatedAt()
        );
    }
}
