package com.naseef.onlineshopping.controller;


import com.naseef.onlineshopping.exception.ProductNotFoundException;
import com.naseef.shoppingbackend.dao.CategoryDAO;
import com.naseef.shoppingbackend.dao.ProductDAO;
import com.naseef.shoppingbackend.dto.Category;
import com.naseef.shoppingbackend.dto.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Naseef M Abdus Sattar on 9/11/2017.
 */
@Controller
public class PageController
{
    private static final Logger logger = LoggerFactory.getLogger(PageController.class);

    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private ProductDAO productDAO;


    /**
     *This Method is used to map the url of the homepage
     */
    @RequestMapping (value = {"/", "/index","/home"})
    public ModelAndView index ()
    {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title" , "Home");

        logger.info("Inside PageController index method - INFO");
        logger.debug("Inside PageController index method - DEBUG");

        //Passing list of Categories from Category DAO which is in shopping-backend
        mv.addObject("categories" , categoryDAO.getList());

        mv.addObject("userClickedHome" , true);
        return mv;
    }

    /**
     *This Method is used to map the url of the About Page
     */
    @RequestMapping (value = {"/about"})
    public ModelAndView about()
    {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "About Us");
        mv.addObject("userClickedAbout" , true);
        return mv;
    }


    /**
     *This Method is used to map the url of the Contact Us page
     */
    @RequestMapping (value = {"/contact"})
    public ModelAndView contact ()
    {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title" , "Contact Us");
        mv.addObject("userClickedContact" , true);
        return mv;
    }


    /**
     *  Methods to load all the products and based on their category
     */
    @RequestMapping (value = {"/show/all/products"})
    public ModelAndView showAllProducts ()
    {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title" , "All Products");

        //Passing list of Categories from Category DAO which is in shopping-backend
        mv.addObject("categories" , categoryDAO.getList());

        mv.addObject("userClickedAllProducts" , true);
        return mv;
    }


    /**
     *  Method to load products based on their category
     */
    @RequestMapping(value = "/show/category/{id}/products")
    public ModelAndView showCategoryProducts(@PathVariable("id") int id)
    {
        ModelAndView mv = new ModelAndView("page");

        //CategoryDAO to fetch a single category
        Category category = null;

        category = categoryDAO.get(id);

        //passing the name of the category to be showed in the title
        mv.addObject("title", category.getName());

        //passing the list of products
        mv.addObject("categories", categoryDAO.getList());

        //passing a single category object
        mv.addObject("category" , category);

        mv.addObject("userClickedCategoryProducts" , true);
        return mv;
    }

    /**
     *  Method to show one product
     */
    @RequestMapping(value = "/show/{id}/product")
    public ModelAndView showSingleProduct (@PathVariable("id") int id) throws ProductNotFoundException
    {
        ModelAndView mv = new ModelAndView("page");

        Product product = productDAO.get(id);
        if (product == null) throw new ProductNotFoundException();

        //Update the view count
        product.setViews(product.getViews()+1);
        productDAO.update(product);
        //----------------------------------

        mv.addObject("title",product.getName());
        mv.addObject("product", product);

        mv.addObject("userClickedShowProduct",true);
        return mv;
    }

}
