package com.naseef.onlineshopping.controller;

import com.naseef.shoppingbackend.dao.CategoryDAO;
import com.naseef.shoppingbackend.dao.ProductDAO;
import com.naseef.shoppingbackend.dto.Category;
import com.naseef.shoppingbackend.dto.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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

    @Autowired
    private ProductDAO productDAO;

    private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

    @RequestMapping(value = "/products",method = RequestMethod.GET)
    public ModelAndView showManageProducts(@RequestParam(name="operation",required=false)String operation)
    {
        ModelAndView mv = new ModelAndView("page");

        mv.addObject("userClickedManageProducts", true);
        mv.addObject("title", "Manage Products");

        //New Product is being created when Admin completes the Product Management Form
        Product newProduct = new Product();
        newProduct.setSupplierId(1);//Admin is the supplier. In Database Admin Id=1
        newProduct.setActive(true);

        mv.addObject("product",newProduct);


        if(operation!=null)
        {
            if(operation.equals("product"))
            {
                mv.addObject("message","Product Submitted Successfully!");
            }
        }

        return mv;
    }

    //Handling Product Submission
    @RequestMapping(value = "/products",method = RequestMethod.POST)
    public String handleProductSubmission(@Valid @ModelAttribute("product") Product modifiedProduct, BindingResult result, Model model)//BingingResult param MUST always ^^ come before the Model param
    {
        //Check if there are any errors
        if (result.hasErrors())
        {
            model.addAttribute("userClickedManageProducts",true);
            model.addAttribute("title","Manage Products");
            model.addAttribute("message","Validation Failed!");
            //Here we should not use "redirect:....." because if used then error message will not get displayed
            return "page";
        }

        logger.info(modifiedProduct.toString());

        //Create a new Product
        productDAO.add(modifiedProduct);

        return "redirect:/onlineshopping/manage/products?operation=product";
    }

    //Returning Categories for all the request mapping
    @ModelAttribute ("categories")
    public List<Category> getCategories()
    {
        return categoryDAO.getList();
    }
}
