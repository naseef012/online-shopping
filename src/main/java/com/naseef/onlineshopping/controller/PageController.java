package com.naseef.onlineshopping.controller;


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

    @RequestMapping (value = {"/about"})
    public ModelAndView about()
    {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "About Us");
        mv.addObject("userClickedAbout" , true);
        return mv;
    }

    @RequestMapping (value = {"/contact"})
    public ModelAndView contact ()
    {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title" , "Contact Us");
        mv.addObject("userClickedContact" , true);
        return mv;
    }

}
