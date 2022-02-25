package com.example.shoppingapi.customer;

import com.example.shoppingapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    //    @Query("select c from Customer c where c.username = ?1")
//    @Query("select c from Customer c where c.username = ?1 and c.password = ?2")
    Customer findByUsernameAndPassword(String username, String password);

    List<Customer> findAll();

}
