package com.example.shoppingapi;

import com.example.shoppingapi.model.User;
import com.example.shoppingapi.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ShoppingApiApplication {

	@Autowired
	private UserRepository userRepository;
	@PostConstruct
	public  void xyz(){
		User   user =new User();
		user.setUserId(1);
		user.setFullName("nanniiz");
		user.setEmail("angkhana");
		userRepository.save(user);

	}

	public static void main(String[] args) {
		SpringApplication.run(ShoppingApiApplication.class, args);
		System.out.println("TEST");
	}

}
