package com.solvd.users.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.xml.sax.SAXParseException;

@Slf4j
@RestControllerAdvice
public class ApiControllerAdvice {

    @ExceptionHandler(SAXParseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleSAXParseException(SAXParseException ex) {
        log.error(ex.getMessage());
        return "Incorrect file or/and content";
    }

}
