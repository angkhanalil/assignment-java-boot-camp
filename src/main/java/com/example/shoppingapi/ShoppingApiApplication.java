package com.example.shoppingapi;

import com.example.shoppingapi.CustomerAddressItem.CustomerAddressItemRepository;
import com.example.shoppingapi.customer.CustomerRepository;
import com.example.shoppingapi.model.Customer;
import com.example.shoppingapi.model.CustomerAddressItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ShoppingApiApplication {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerAddressItemRepository customerAddressItemRepository;

    @PostConstruct
    public void xyz() {
        CustomerAddressItem addressItem = new CustomerAddressItem();
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
        customer.setUsername("abc@gmail.com");
        customer.setPassword("1234");
        customer.setFirstname("Angkhana");
        customer.setLastname("Lila");
        customer.setPhoneno("0999999999");
        customerRepository.save(customer);


        customer.setCustomerAddress(customerAddressItemList);
        Customer cust = customerRepository.save(customer);
        System.out.print(cust);
    }

    public static void main(String[] args) {
        SpringApplication.run(ShoppingApiApplication.class, args);
        System.out.println("TEST");
    }

}
