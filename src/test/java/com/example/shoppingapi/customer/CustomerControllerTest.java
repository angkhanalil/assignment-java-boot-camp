package com.example.shoppingapi.customer;

import com.example.shoppingapi.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private CustomerRepository customerRepository;

    @Test
    void signIn() {
        //Arrange
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

        when(customerRepository.findByUsernameAndPassword("abc@gmail.com","1234")).thenReturn(customer);

        //Act
        Customer result = testRestTemplate.postForObject("/customer/SignIn", requestSignIn, Customer.class);
        //Assert
        assertNotNull(result);

    }

    @Test
    void findCustomerAll() {

    }
}