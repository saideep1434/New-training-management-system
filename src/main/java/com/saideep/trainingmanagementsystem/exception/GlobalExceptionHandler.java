package com.saideep.trainingmanagementsystem.exception;


import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
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





}
