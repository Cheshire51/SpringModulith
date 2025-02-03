package com.example.LearnModulith.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@ControllerAdvice
public class GlobalExceptionHandler  {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    protected ResponseEntity<Map<String, List<String>>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<String> list = ex.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .toList();
        return new ResponseEntity<>(getErrorMap(list), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ModulithException.class})
    public ResponseEntity<Response> HandleModulithException(ModulithException ex)
    {
        return new ResponseEntity<>(new Response(ex.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }
    private Map<String, List<String>> getErrorMap(List<String> list)
    {
        Map<String, List<String>> map = new HashMap<>();
        map.put("fieldErrors", list);
        return map;
    }
}
