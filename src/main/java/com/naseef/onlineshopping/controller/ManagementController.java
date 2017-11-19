package com.naseef.onlineshopping.controller;

import com.naseef.shoppingbackend.dao.CategoryDAO;
import com.naseef.shoppingbackend.dto.Category;
import com.naseef.shoppingbackend.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created By Naseef M Abdus Sattar on 11/19/2017 at 12:42 PM
 */
@Controller
@RequestMapping("/manage")
public class ManagementController
{
    @Autowired
    private CategoryDAO categoryDAO;

    @RequestMapping(value = "/products",method = RequestMethod.GET)
    public ModelAndView showManageProducts()
    {
        ModelAndView mv = new ModelAndView("page");

        mv.addObject("userClickedManageProducts", true);
        mv.addObject("title", "Manage Products");

        //New Product is being created when Admin completes the Product Management Form
        Product newProduct = new Product();
        newProduct.setSupplierId(1);//Admin is the supplier. In Database Admin Id=1
        newProduct.setActive(true);

        mv.addObject("product",newProduct);


        return mv;
    }

    //Returning Categories for all the request mapping
    @ModelAttribute ("categories")
    public List<Category> getCategories()
    {
        return categoryDAO.getList();
    }
}
