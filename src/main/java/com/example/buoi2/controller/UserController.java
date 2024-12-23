package com.example.buoi2.controller;

import com.example.buoi2.dto.request.ApiResponse;
import com.example.buoi2.dto.request.UserCreationRequest;
import com.example.buoi2.dto.request.UserUpdateRequest;
import com.example.buoi2.dto.response.UserResponse;
import com.example.buoi2.entity.User;
import com.example.buoi2.exception.AppException;
import com.example.buoi2.exception.ErrorCode;
import com.example.buoi2.mapper.UserMapper;
import com.example.buoi2.repository.UserRepository;
import com.example.buoi2.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequiredArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ApiResponse<List<UserResponse>> getUsers() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        System.out.println("Username " + authentication.getName());
        authentication.getAuthorities().forEach(s-> System.out.println(s.getAuthority()));

        ApiResponse<List<UserResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.getUsers());
        return apiResponse;
    }

    @PostMapping
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();

        apiResponse.setResult(userService.createUser(request));
//        apiResponse.setMessage("User has been created");

        return apiResponse;
    }

    @GetMapping("{userId}")
    UserResponse getUser(@PathVariable int userId) {
        return userService.getUser(userId);
    }

    @PutMapping("{userId}")
    UserResponse updateUser(@PathVariable int userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("{userId}")
    String deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
        return "User has been deleted";
    }

    @GetMapping("myinfo")
    ApiResponse<UserResponse> getMyInfo() {
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.getMyInfo());
        return apiResponse;
    }
}
