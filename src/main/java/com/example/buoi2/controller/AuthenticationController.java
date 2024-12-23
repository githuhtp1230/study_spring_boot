package com.example.buoi2.controller;

import com.example.buoi2.dto.request.ApiResponse;
import com.example.buoi2.dto.request.AuthenticationRequest;
import com.example.buoi2.dto.request.IntrospectRequest;
import com.example.buoi2.dto.response.AuthenticationResponse;
import com.example.buoi2.dto.response.IntrospectResponse;
import com.example.buoi2.service.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("login")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        ApiResponse<AuthenticationResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(authenticationService.authenticate(request));
        return apiResponse;
    }

    @PostMapping("introspect")
    ApiResponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request) {
        ApiResponse<IntrospectResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(authenticationService.introspect(request));
        return apiResponse;
    }
}
