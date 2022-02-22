package com.example.shoppingapi.product;

public class ProductNotFoundException extends  RuntimeException{
    public ProductNotFoundException(String message){
        super(message);
    }
}
