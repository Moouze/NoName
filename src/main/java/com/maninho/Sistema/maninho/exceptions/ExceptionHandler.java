package com.maninho.Sistema.maninho.exceptions;

import com.maninho.Sistema.maninho.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidationExceptions(MethodArgumentNotValidException ex){
        var fieldError = ex.getBindingResult().getFieldError();
        String field = fieldError.getField();
        String message = fieldError.getDefaultMessage();

        String errorCode = switch (field) {
            case "login" -> "INVALID_EMAIL";
            case "password" -> "INVALID_PASSWORD";
            default -> "VALIDATION_ERROR";
        };

        ErrorResponseDTO errorResponse = new ErrorResponseDTO(HttpStatus.BAD_REQUEST.value(),
                errorCode, message, field, LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
