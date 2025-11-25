package com.maninho.Sistema.maninho.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponseDTO {

    private int status;
    private String errorCode;
    private String message;
    private String field;
    private LocalDateTime timestamp;
}
