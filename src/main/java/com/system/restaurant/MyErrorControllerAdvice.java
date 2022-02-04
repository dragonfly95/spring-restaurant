package com.system.restaurant;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class MyErrorControllerAdvice {

    @ExceptionHandler({BindException.class, ValidCustomException.class})
    public ResponseEntity<String> processValidationError(BindException exception) {
        BindingResult bindingResult = exception.getBindingResult();

        StringBuffer msg = new StringBuffer();
        for (ObjectError error : bindingResult.getAllErrors()) {
            msg.append(error.getDefaultMessage() + "\n");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;charset=UTF-8");
        return new ResponseEntity(new ResponseVO(msg.toString()), headers, HttpStatus.OK);
    }
}
