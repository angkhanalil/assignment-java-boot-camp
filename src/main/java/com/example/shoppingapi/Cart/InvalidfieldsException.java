package com.example.shoppingapi.Cart;

public class InvalidfieldsException extends RuntimeException {
    public InvalidfieldsException(String name){
        super(name);
    }
}
