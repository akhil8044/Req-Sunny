package com.demo.exceptions;

import com.demo.Model.Response;
import lombok.AllArgsConstructor;


public class PlanExceptions extends RuntimeException {

    public PlanExceptions(String message){
        super(message);
    }


}
