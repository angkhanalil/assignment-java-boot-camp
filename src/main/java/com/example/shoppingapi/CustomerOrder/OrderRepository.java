package com.example.shoppingapi.CustomerOrder;

import com.example.shoppingapi.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<CustomerOrder,Integer> {

//    @Query("select c from CustomerOrder c where c.orderid = ?1")
    CustomerOrder findByOrderid(String orderid);

//    @Query("select c from CustomerOrder c where c.userid = ?1")
    List<CustomerOrder> findByUserid(Integer userid);
}
