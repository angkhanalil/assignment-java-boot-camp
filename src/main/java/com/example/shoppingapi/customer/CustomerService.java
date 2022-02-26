package com.example.shoppingapi.customer;

import com.example.shoppingapi.Shipping.CustomerAddressItemService;
import com.example.shoppingapi.model.Customer;
import com.example.shoppingapi.model.CustomerAddressItem;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerAddressItemService customerAddressItemService;

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }



    public ResponseEntity<Customer> ShowCustomerData(@NotNull RequestSignIn signIn) {
        String username = signIn.getEmail();
        String password = signIn.getPassword();
        Customer result = customerRepository.findByUsernameAndPassword(username, password);

        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        throw new CustomerNotFoundException(username);

    }

    public ResponseEntity<List<Customer>> CustomerAll() {

        List<Customer> result = customerRepository.findAll();
        if (!result.isEmpty()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        throw new CustomerNotFoundException("Customer");

    }


}
