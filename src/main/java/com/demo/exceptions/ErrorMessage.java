package com.demo.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum ErrorMessage {

    NO_PLANS_FOUND("No plans found for the filter","DL162","This is caused as there are no plans with the given filter"),
    WRONG_PLANTYPE("Please enter correct planType","DL168","Please enter the correct planType.");


    @Getter
    private final String message;
    @Getter
    private final String errorCode;
    @Getter
    private final String description;

}
