package com.example.demo.exception;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handleBad(BadRequestException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
