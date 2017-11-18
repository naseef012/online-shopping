package com.naseef.onlineshopping.exception;

import com.naseef.shoppingbackend.dto.Product;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Created By Naseef M Abdus Sattar on 11/17/2017 at 11:56 AM
 */

@ControllerAdvice
public class GlobalDefaultExceptionHandler
{

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleNoHandlerFoundException()
    {
        ModelAndView mv = new ModelAndView("error");

        mv.addObject("errorTitle", "The Page is not constructed");

        mv.addObject("errorDescription", "The Page You are looking for is not available now");

        mv.addObject("title", "404 Error Page");

        return mv;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handleProductNotFoundException()
    {
        ModelAndView mv = new ModelAndView("error");

        mv.addObject("errorTitle", "Product Not Available");

        mv.addObject("errorDescription", "The Product You are looking for is not available now");

        mv.addObject("title", "Product Unavailable");

        return mv;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex)
    {
        ModelAndView mv = new ModelAndView("error");

        mv.addObject("errorTitle", "Contact Your Administrator");

        mv.addObject("errorDescription", ex.toString());

        mv.addObject("title", "Error");

        return mv;
    }



}
