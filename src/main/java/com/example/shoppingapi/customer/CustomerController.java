package com.example.shoppingapi.customer;

import com.example.shoppingapi.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer/SignIn")
    public ResponseEntity<Customer> SignIn(@RequestBody RequestSignIn singin) {
        // Sing in with email
        return customerService.ShowCustomerData(singin);
    }

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> findCustomerAll() {
        return customerService.CustomerAll();
    }

}
