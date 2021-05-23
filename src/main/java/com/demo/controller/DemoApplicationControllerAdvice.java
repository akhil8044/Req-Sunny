package com.demo.controller;

import com.demo.Model.Response;
import com.demo.exceptions.PlanExceptions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.awt.*;

@ControllerAdvice
public class DemoApplicationControllerAdvice {


    @ExceptionHandler
    public ResponseEntity<Response> DemoException(PlanExceptions planExceptions){
      String msg =  planExceptions.getMessage();


    }
}
