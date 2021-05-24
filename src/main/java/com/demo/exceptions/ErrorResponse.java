package com.demo.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {

private String message;
private String errorCode;
private String errorDescription;


}
