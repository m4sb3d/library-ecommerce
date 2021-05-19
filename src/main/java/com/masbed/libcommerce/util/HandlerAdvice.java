package com.masbed.libcommerce.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestControllerAdvice
public class HandlerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {

        Collection<String> messages = new ArrayList<>();
        BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        fieldErrors.forEach(
                fieldError -> {
                    String message = String.format("Field %s %s", fieldError.getField(), fieldError.getDefaultMessage());
                    messages.add(message);
                });

        StandardError standardError = new StandardError(messages);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);

    }

    @ExceptionHandler
    public ResponseEntity<StandardError> handleResponseStatusException(ResponseStatusException responseStatusException) {
        Collection<String> messages = new ArrayList<>();
        messages.add(responseStatusException.getReason());

        StandardError standardError = new StandardError(messages);
        return ResponseEntity.status(responseStatusException.getStatus()).body(standardError);
    }


}
