package com.example.shoppingapi.Cart;

public class CartNotFoundException extends RuntimeException{
    public CartNotFoundException(String name){
        super(name);
    }
}
