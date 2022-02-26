package com.example.shoppingapi.Shipping;

import com.example.shoppingapi.customer.RequestSignIn;
import com.example.shoppingapi.model.Customer;
import com.example.shoppingapi.model.CustomerAddressItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerAddressItemController {

    @Autowired
    private CustomerAddressItemService customerAddressItemService;

    // add new address
    @PostMapping("/shipping")
    public CustomerAddressItem Shipping(@RequestBody RequestShipping RequestShipping) {
        // Sing in with email
        return customerAddressItemService.addShipping(RequestShipping);
    }
}
