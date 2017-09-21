package main.java.com.naseef.onlineshopping.controller;

import com.sun.javafx.sg.prism.NGShape;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        mv.addObject("title" , "Home");
        mv.addObject("userClickedHome" , true);
        return mv;
    }

}
