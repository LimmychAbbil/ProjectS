package net.lim.recipes.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView handleInvalidNumberException(NumberFormatException e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("exceptionPage");
        modelAndView.addObject("exception", e);

        return modelAndView;
    }
    
}
