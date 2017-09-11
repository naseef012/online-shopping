package main.java.com.naseef.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by USER on 9/11/2017.
 */
@Controller
public class PageController
{
    @RequestMapping (value = {"/", "/index","/home"})
    public ModelAndView index ()
    {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("greeting" , "Welcome to Spring MVC");
        return mv;
    }
}
