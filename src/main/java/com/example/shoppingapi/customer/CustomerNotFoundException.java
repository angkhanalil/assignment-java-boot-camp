package com.example.shoppingapi.customer;

public class CustomerNotFoundException  extends RuntimeException {

    public CustomerNotFoundException(String username) {
        super(username);
    }
}
