package com.example.shoppingapi.CustomerOrder;

import com.example.shoppingapi.Cart.CartResponse;
import com.example.shoppingapi.model.CustomerOrder;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerOrderController {

    @Autowired
    private CustomerOrderService customerOrderService;

    //    add to cart
    @PostMapping("/order")
    public String confirmorder(@RequestBody @NotNull RequestCustomerOrder customerOrder){
        return customerOrderService.confirmOrder(customerOrder);

    }

    @GetMapping("/order/{orderid}")
    public ResponseEntity<List<CustomerOrder>> Cart(@PathVariable String orderid){
        return  null;
    }
}
