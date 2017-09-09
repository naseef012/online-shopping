package main.java.com.naseef.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by USER on 8/25/2017.
 */
@Controller
public class PageController
{
    @RequestMapping (value = {"/", "/home", "/index"})
    public ModelAndView index()
    {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("greetung" , "Welcome To Spring Project");
        return mv;
    }
}
