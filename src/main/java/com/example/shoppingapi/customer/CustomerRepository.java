package com.example.shoppingapi.customer;

import com.example.shoppingapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query("select c from Customer c where c.username = ?1")
    Customer findByUsername(String username);
}
