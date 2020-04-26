package com.genpact.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.genpact.model.ResultWrapper;

/**
 * This is the default exception handling class for showing so default message on the 
 * UI screen in case some error occurs in servicing the request.
 * @author Reetesh R Nayak
 *
 */
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResultWrapper<String> handleNotFoundException(RuntimeException ex) {
        ResultWrapper<String> result = new ResultWrapper<String>(400, "Bad request", null);
        return result;
    }

}
