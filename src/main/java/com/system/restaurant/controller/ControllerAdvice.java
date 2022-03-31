package com.system.restaurant.controller;

import com.system.restaurant.domain.*;
import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.validation.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.*;

import javax.servlet.http.*;

@Slf4j
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handle(RuntimeException e, HttpServletRequest request) {

        HandlerMethod handlerMethod = (HandlerMethod) request.getAttribute("org.springframework.web.servlet.HandlerMapping.bestMatchingHandler");
        return new ResponseEntity(new HttpErrorResponse(500, e.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> processValidationError(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();

        StringBuffer msg = new StringBuffer();
        for (ObjectError error : bindingResult.getAllErrors()) {
            msg.append(error.getDefaultMessage() + "\n");
        }
        return new ResponseEntity(msg.toString(), HttpStatus.OK);
    }
}
