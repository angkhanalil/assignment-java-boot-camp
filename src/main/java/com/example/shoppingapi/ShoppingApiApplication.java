package com.example.shoppingapi;

import com.example.shoppingapi.customer.CustomerRepository;
import com.example.shoppingapi.model.Customer;
import com.example.shoppingapi.model.User;
import com.example.shoppingapi.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ShoppingApiApplication {

	@Autowired
	private CustomerRepository customerRepository;
	@PostConstruct
	public  void xyz(){
		Customer customer =new Customer();
		customer.setId(1);
		customer.setUsername("abc@gmail.com");
		customer.setPassword("1234");
		customer.setFirstname("Angkhana");
		customer.setLastname("Lila");
		customer.setPhoneno("0999999999");

		customerRepository.save(customer);

	}

	public static void main(String[] args) {
		SpringApplication.run(ShoppingApiApplication.class, args);
		System.out.println("TEST");
	}

}
