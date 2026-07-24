package com.saideep.trainingmanagementsystem.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex)
    {

        Map<String,String> ans = new HashMap<>();

        for(FieldError error : ex.getBindingResult().getFieldErrors())
        //list stores the errors and error access each error1 and erro2 and so...on now
        {
            ans.put(error.getField(), error.getDefaultMessage());
        }

        return ans;
    }

//    @ExceptionHandler(UserNotFoundException.class)
//    public String handleUserException(UserNotFoundException ex)
//    {
//       return ex.getMessage(); // currently we are returning only the message body but see here use not found
//        // but still spring be like status 200k but it should not be the case it should be some 404 not found
//    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserException(UserNotFoundException ex)
    {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }





}
