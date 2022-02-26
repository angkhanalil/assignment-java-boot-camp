package com.example.shoppingapi.CustomerOrder;

import com.example.shoppingapi.model.CustomerOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerOrderItemRepository extends JpaRepository<CustomerOrderItem ,Integer> {

//    @Query("select c from CustomerOrderItem c where c.orderid = ?1")
    List<CustomerOrderItem> findByOrderid(String orderid);
}
