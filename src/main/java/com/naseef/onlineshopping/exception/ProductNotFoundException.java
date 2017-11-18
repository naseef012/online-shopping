package com.naseef.onlineshopping.exception;

import java.io.Serializable;

/**
 * Created By Naseef M Abdus Sattar on 11/18/2017 at 12:59 AM
 */
public class ProductNotFoundException extends Exception implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String message;

    public ProductNotFoundException()
    {
        this("Product is not available");
    }

    public ProductNotFoundException(String message)
    {
        this.message = System.currentTimeMillis()+": "+message;
    }

   @Override
    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
