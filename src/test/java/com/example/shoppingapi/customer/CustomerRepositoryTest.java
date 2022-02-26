package com.example.shoppingapi.customer;

import com.example.shoppingapi.model.Customer;
import com.example.shoppingapi.model.CustomerAddressItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void findByUsernameAndPassword() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setUsername("abc@gmail.com");
        customer.setPassword("1234");
        customer.setFirstname("Angkhana");
        customer.setLastname("Lila");
        customer.setPhoneno("0999999999");
        customerRepository.save(customer);

        Customer result = customerRepository.findByUsernameAndPassword("abc@gmail.com","1234");
        assertNotNull(result);
    }

    @Test
    void findAll() {

        Customer customer = new Customer();
        customer.setId(1);
        customer.setUsername("abc@gmail.com");
        customer.setPassword("1234");
        customer.setFirstname("Angkhana");
        customer.setLastname("Lila");
        customer.setPhoneno("0999999999");
        customerRepository.save(customer);

        List<Customer> result = customerRepository.findAll();

        assertFalse(result.isEmpty());
    }
}