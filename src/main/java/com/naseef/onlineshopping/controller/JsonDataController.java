package com.naseef.onlineshopping.controller;

import com.naseef.shoppingbackend.dao.ProductDAO;
import com.naseef.shoppingbackend.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created By Naseef M Abdus Sattar on 10/29/2017 at 2:40 PM
 */
@Controller
@RequestMapping("/json/data")
public class JsonDataController
{
    @Autowired
    private ProductDAO productDAO;

    @RequestMapping(value = "/all/products")
    /*
    @ResponseBody will look for a return data format(json/xml) and since I added JSON in backend and backend is a dependency of this front end
    the data returned will be in JSON format.
     */
    @ResponseBody
    public List<Product> getAllProducts()
    {
        return productDAO.getActiveProducts();
    }

    @RequestMapping(value = "/category/{id}/products")
    @ResponseBody
    public List<Product> getProductsByCategory(@PathVariable int id)
    {
        return productDAO.getActiveProductByCategory(id);
    }



}
