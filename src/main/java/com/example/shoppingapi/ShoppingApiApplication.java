package com.example.shoppingapi;

import com.example.shoppingapi.CustomerAddressItem.CustomerAddressItemRepository;
import com.example.shoppingapi.customer.CustomerRepository;
import com.example.shoppingapi.model.Customer;
import com.example.shoppingapi.model.CustomerAddressItem;
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
        customer.setId(1);
        customer.setUsername("abc@gmail.com");
        customer.setPassword("1234");
        customer.setFirstname("Angkhana");
        customer.setLastname("Lila");
        customer.setPhoneno("0999999999");
        customerRepository.save(customer);

        CustomerAddressItem addressItem = new CustomerAddressItem();
        Customer cust  = customerRepository.findByUsernameAndPassword("abc@gmail.com","1234");
        addressItem.setCustomerid(cust.getId());
        addressItem.setAddess("address1");
        addressItem.setFullname("name1");

        CustomerAddressItem addressItem2 = new CustomerAddressItem();
        addressItem2.setCustomerid(cust.getId());
        addressItem2.setAddess("address2");
        addressItem2.setFullname("name2");


        customerAddressItemRepository.save(addressItem);
        customerAddressItemRepository.save(addressItem2);


        System.out.println("save");

    }

    public static void main(String[] args) {
        SpringApplication.run(ShoppingApiApplication.class, args);
        System.out.println("TEST");
    }

}
