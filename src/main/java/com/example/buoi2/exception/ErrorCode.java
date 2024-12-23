package com.example.buoi2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public enum ErrorCode {

    UNCATEGORIZED_EXCEPTION(999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR), // Lỗi máy chủ
    USER_EXISTED(409, "User existed", HttpStatus.CONFLICT), // Xung đột dữ liệu
    USERNAME_INVALID(400, "Username must be at least 3 characters", HttpStatus.BAD_REQUEST), // Lỗi đầu vào
    INVALID_PASSWORD(400, "Password must be at least 8 characters", HttpStatus.BAD_REQUEST), // Lỗi đầu vào
    INVALID_KEY(401, "Invalid key", HttpStatus.UNAUTHORIZED), // Lỗi xác thực
    USER_NOT_FOUND(404, "User not found", HttpStatus.NOT_FOUND), // Tài nguyên không tìm thấy
    UNAUTHENTICATED(401, "Unauthenticated", HttpStatus.UNAUTHORIZED) // Lỗi xác thực
    ;

    private int code;
    private String message;
    private HttpStatusCode statusCode;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatusCode statusCode) {
        this.statusCode = statusCode;
    }
}
