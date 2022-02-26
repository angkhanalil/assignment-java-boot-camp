package com.example.shoppingapi.CustomerOrder;

public class CustomerOrderNotFoundException extends RuntimeException{

    public CustomerOrderNotFoundException(String orderid){
        super(orderid);
    }
}
