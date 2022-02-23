package com.example.shoppingapi.customer;

import com.example.shoppingapi.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/SignIn")
    public ResponseEntity<Customer> SignIn(@RequestBody RequestSignIn singin) {
        // Sing in with email
        return customerService.ShowCustomerData(singin);
    }
}
