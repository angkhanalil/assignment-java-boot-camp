package com.example.shoppingapi;

import com.example.shoppingapi.Shipping.CustomerAddressItemRepository;
import com.example.shoppingapi.customer.CustomerRepository;
import com.example.shoppingapi.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ShoppingApiApplication {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerAddressItemRepository customerAddressItemRepository;

    @PostConstruct
    public void xyz() {

        Customer customer = new Customer();
//        customer.setId();
        customer.setUsername("abc@gmail.com");
        customer.setPassword("1234");
        customer.setFirstname("Angkhana");
        customer.setLastname("Lila");
        customer.setPhoneno("0999999999");

        Customer cust = customerRepository.save(customer);
        System.out.print("Save");
    }
    public static void main(String[] args) {
        SpringApplication.run(ShoppingApiApplication.class, args);
        System.out.println("TEST");
    }

}
