package com.example.shoppingapi.Cart;


import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CartControllerAdvice {
    @ExceptionHandler(CartNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userNotFound(@NotNull CartNotFoundException e){
        return "Cart not found";
    }

    @ExceptionHandler(InvalidfieldsException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String InvalidField(@NotNull InvalidfieldsException e){
        return e.getMessage()  + " is Invalid!!";
    }
}
