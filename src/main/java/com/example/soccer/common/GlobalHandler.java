package com.example.soccer.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandler {
    @ExceptionHandler(RuntimeException.class)
    public CustomException handleRuntimeException(RuntimeException e) {
        return new CustomException(500, e.getMessage());
    }
}
