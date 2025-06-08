package com.quiz.application.controller;

import com.quiz.application.dto.UserRequestDto;
import com.quiz.application.dto.UserResponseDto;
import com.quiz.application.service.UserService;
import com.quiz.application.util.ResponseUtil;
import com.quiz.application.util.ResponseUtil.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create new user
    @PostMapping
    public ResponseEntity<ApiResponse<UserResponseDto>> createUser(
            @Valid @RequestBody UserRequestDto userRequest) {
        UserResponseDto created = userService.createUser(userRequest);
        return ResponseEntity.ok(ResponseUtil.success(created));
    }

    // Delete user by ID
    @DeleteMapping
    public ResponseEntity<ApiResponse<Void>> deleteUser(
            @RequestParam("userId") Integer userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok(ResponseUtil.success(null));
    }

    // Update user status (activate/suspend)
    @PatchMapping("/{userId}/status")
    public ResponseEntity<ApiResponse<UserResponseDto>> updateUserStatus(
            @PathVariable Integer userId,
            @RequestParam("activate") Boolean activate) {
        UserResponseDto updated = userService.updateUserStatus(userId, activate);
        return ResponseEntity.ok(ResponseUtil.success(updated));
    }

    // Get all users or single user by ID
    @GetMapping
    public ResponseEntity<ApiResponse<?>> getUsers(
            @RequestParam(value = "userId", required = false) Integer userId) {
        if (userId != null) {
            UserResponseDto user = userService.getUserById(userId);
            return ResponseEntity.ok(ResponseUtil.success(user));
        } else {
            List<UserResponseDto> users = userService.getAllUsers();
            return ResponseEntity.ok(ResponseUtil.success(users));
        }
    }
}
