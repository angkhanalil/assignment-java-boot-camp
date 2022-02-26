package com.example.shoppingapi.customer;

import com.example.shoppingapi.model.Customer;
import com.example.shoppingapi.model.CustomerAddressItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @Test
    void showCustomerData() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setUsername("abc@gmail.com");
        customer.setPassword("1234");
        customer.setFirstname("Angkhana");
        customer.setLastname("Lila");
        customer.setPhoneno("0999999999");


        RequestSignIn requestSignIn = new RequestSignIn();
        requestSignIn.setEmail("abc@gmail.com");
        requestSignIn.setPassword("1234");

        when(customerRepository.findByUsernameAndPassword("abc@gmail.com", "1234")).thenReturn(customer);

        CustomerService customerService = new CustomerService();
        customerService.setCustomerRepository(customerRepository);
        ResponseEntity<Customer> result = customerService.ShowCustomerData(requestSignIn);

        assertEquals(new ResponseEntity<>(customer, HttpStatus.OK), result);
    }

    @Test
    void customerAll() {

        List<Customer> customerslist = new ArrayList<>();
        Customer customer = new Customer();
        customer.setId(1);
        customer.setUsername("abc@gmail.com");
        customer.setPassword("1234");
        customer.setFirstname("Angkhana");
        customer.setLastname("Lila");
        customer.setPhoneno("0999999999");
        customerslist.add(customer);

        when(customerRepository.findAll()).thenReturn(customerslist);
        CustomerService customerService = new CustomerService();
        customerService.setCustomerRepository(customerRepository);

        ResponseEntity<List<Customer>> result = customerService.CustomerAll();

        assertEquals(1,result.getBody().size());
    }
}