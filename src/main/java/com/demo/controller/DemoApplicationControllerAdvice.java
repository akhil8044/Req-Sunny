package com.demo.controller;

import com.demo.exceptions.ErrorMessage;
import com.demo.exceptions.ErrorResponse;
import com.demo.exceptions.PlanExceptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@Slf4j
public class DemoApplicationControllerAdvice extends ResponseEntityExceptionHandler {


  @ExceptionHandler
  public ResponseEntity<ErrorResponse> DemoException(PlanExceptions planExceptions) {
    ErrorResponse errorResponse = new ErrorResponse(planExceptions.getMessage(), ErrorMessage.WRONG_PLAN_TYPE.getErrorCode(),
            ErrorMessage.WRONG_PLAN_TYPE.getDescription());
    log.info("Wrong Plan type entered by user");
    return ResponseEntity.badRequest().body(errorResponse);


  }
}
