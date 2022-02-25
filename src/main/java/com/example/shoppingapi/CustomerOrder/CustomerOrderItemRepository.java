package com.example.shoppingapi.CustomerOrder;

import com.example.shoppingapi.model.CustomerOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderItemRepository extends JpaRepository<CustomerOrderItem ,Integer> {
}
