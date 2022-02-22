package com.example.shoppingapi.Order;

import com.example.shoppingapi.model.Cart;
import com.example.shoppingapi.model.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void findCustomerOrderbyUser(String userid) {

    }

    public void findCustomerOrderbyOrderId(String orderid) {

    }

    //confirm order
    @Transactional
    public ResponseEntity<CustomerOrder> confirmOrder(CustomerOrder order) {
// check invalid
        CustomerOrder cust_order = orderRepository.save(order);
        if (cust_order == null) {
            return new ResponseEntity<>(cust_order, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cust_order, HttpStatus.CREATED);

    }

}
