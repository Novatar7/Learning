package com.example.learn.Dto;

import com.example.learn.Entity.InputFieldError;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RestControllerAdvice
public class CustomResponse extends RuntimeException {

    public static ResponseEntity<String> empty() {
        String message = "Please provide the required value";
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public CustomResponse(String message) {
        super(message);
    }

    @ExceptionHandler(CustomResponse.class)
    public static ResponseEntity<String> handleExceptionWithMessage(CustomResponse customResponse) {
        return new ResponseEntity<>(customResponse.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap;
    }
    @Data
    public class UpdateResponse {

        private List<InputFieldError> fieldErrors;

        // getter and setter
    }
}
