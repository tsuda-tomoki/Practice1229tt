package com.example.presentation;

import com.example.domain.Details;
import com.example.domain.ExceptionHandResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionHandResponse> getException() {
        List<Details> detailsList = List.of(new Details("firstName must not be blank"));
        return new ResponseEntity<ExceptionHandResponse>(
                new ExceptionHandResponse(
                        "0002", "request validation error is occurred.", detailsList
                ), HttpStatus.BAD_REQUEST);
    }
}
