package com.demo.controller;

import com.demo.exceptions.ErrorMessage;
import com.demo.exceptions.ErrorResponse;
import com.demo.exceptions.PlanExceptions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class DemoApplicationControllerAdvice extends ResponseEntityExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<ErrorResponse> DemoException(PlanExceptions planExceptions){
        ErrorResponse errorResponse = new ErrorResponse(planExceptions.getMessage(), ErrorMessage.WRONG_PLANTYPE.getErrorCode(),
                                            ErrorMessage.WRONG_PLANTYPE.getDescription());

        return ResponseEntity.badRequest().body(errorResponse);


    }
}
