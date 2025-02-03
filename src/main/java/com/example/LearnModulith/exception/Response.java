package com.example.LearnModulith.exception;

import org.springframework.http.HttpStatus;

public record Response(String message, HttpStatus status) {
}
