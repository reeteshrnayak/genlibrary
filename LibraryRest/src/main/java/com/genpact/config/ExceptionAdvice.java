package com.genpact.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

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
    
    @ExceptionHandler(LibraryException.class)
    public ModelAndView handleMyException(LibraryException mex) {
        ModelAndView model = new ModelAndView();
        model.addObject("errCode", mex.getErrCode());
        model.addObject("errMsg", mex.getErrMsg());
        model.setViewName("error/generic_error");
        return model;
    }
 
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
        ModelAndView model = new ModelAndView();
        model.addObject("errMsg", "This is a exception class message.");
        model.setViewName("error/generic_error");
        return model;
    }

}
