package com.example.shoppingapi.CustomerOrder;

import com.example.shoppingapi.customer.CustomerNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomerOrderControllerAdvice {

    @ExceptionHandler(CustomerOrderNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String CustomerOrderNotFound(@NotNull CustomerOrderNotFoundException e){

        return  "Order Not Found.";
    }
}
