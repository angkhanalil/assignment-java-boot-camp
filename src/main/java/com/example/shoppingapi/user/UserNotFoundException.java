package com.example.shoppingapi.user;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String name){
        super(name);
    }
}
