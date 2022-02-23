package com.example.shoppingapi.customer;

import com.example.shoppingapi.model.Customer;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public ResponseEntity<Customer> ShowCustomerData(@NotNull RequestSignIn signIn) {
        String username = signIn.getEmail();
        Customer result = customerRepository.findByUsername(username);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK) ;
        }
        throw new CustomerNotFoundException(username);

    }


}
