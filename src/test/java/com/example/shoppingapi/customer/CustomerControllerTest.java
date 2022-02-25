package com.example.shoppingapi.customer;

import com.example.shoppingapi.model.Customer;
import com.example.shoppingapi.model.CustomerAddressItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
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
        CustomerAddressItem addressItem = new CustomerAddressItem();
        addressItem.setId(1);
        addressItem.setAddess("address1");
        addressItem.setFullname("name1");

        CustomerAddressItem addressItem2 = new CustomerAddressItem();
        addressItem2.setAddess("address2");
        addressItem2.setFullname("name2");

        List<CustomerAddressItem> customerAddressItemList = new ArrayList<>();
        customerAddressItemList.add(addressItem);
        customerAddressItemList.add(addressItem2);

        Customer customer = new Customer();
        customer.setId(1);
        customer.setUsername("test@gmail.com");
        customer.setPassword("1234");
        customer.setFirstname("Angkhana");
        customer.setLastname("Lila");
        customer.setPhoneno("0999999999");
        customerRepository.save(customer);


        customer.setCustomerAddress(customerAddressItemList);
        Customer cust = customerRepository.save(customer);
        when(customerRepository.findByUsernameAndPassword("test@gmail.com","1234")).thenReturn(customer);

        RequestSignIn requestSignIn = new RequestSignIn();
        requestSignIn.setEmail("test@gmail.com");
        requestSignIn.setPassword("1234");
        //Act
        Customer result = testRestTemplate.postForObject("/customer/SignIn", requestSignIn, Customer.class);
        //Assert
        assertNotNull(result);

    }


    @Test
    void findCustomerAll() {

        //Arrange
        CustomerAddressItem addressItem = new CustomerAddressItem();
        addressItem.setId(1);
        addressItem.setAddess("address1");
        addressItem.setFullname("name1");

        CustomerAddressItem addressItem2 = new CustomerAddressItem();
        addressItem2.setAddess("address2");
        addressItem2.setFullname("name2");

        List<CustomerAddressItem> customerAddressItemList = new ArrayList<>();
        customerAddressItemList.add(addressItem);
        customerAddressItemList.add(addressItem2);

        List<Customer> customerList = new ArrayList<>();
        Customer customer = new Customer();
        customer.setId(1);
        customer.setUsername("test@gmail.com");
        customer.setPassword("1234");
        customer.setFirstname("Angkhana");
        customer.setLastname("Lila");
        customer.setPhoneno("0999999999");
        customerList.add(customer);

        customer.setCustomerAddress(customerAddressItemList);
        when(customerRepository.findAll()).thenReturn(customerList);

        //Act
         ResponseEntity<String> result =  testRestTemplate.getForEntity("/customer", String.class);

        assertEquals(HttpStatus.OK,result.getStatusCode());
    }
}