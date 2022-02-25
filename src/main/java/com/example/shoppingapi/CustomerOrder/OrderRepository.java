package com.example.shoppingapi.CustomerOrder;

import com.example.shoppingapi.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<CustomerOrder,Integer> {

}
