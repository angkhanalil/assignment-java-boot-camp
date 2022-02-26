package com.example.shoppingapi.CustomerOrder;

import com.example.shoppingapi.model.CustomerOrder;
import com.example.shoppingapi.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @BeforeEach
    void setup(){
        CustomerOrder order  = new CustomerOrder();
        order.setTransOrder(1);
        order.setOrderid("ABC");
        order.setOrderstatus("comfirm");
        order.setOrderdate(new Date());
        order.setUserid(1);
        order.setPaymentdate(new Date());
        order.setPaymenttype("credit");

        orderRepository.save(order);

    }

    @Test
    void findByOrderid() {

        //Act
        CustomerOrder result = orderRepository.findByOrderid("ABC");
        //Assert
        assertNotNull(result);

    }

    @Test
    void findByUserid() {

        //Act
        List<CustomerOrder> result = orderRepository.findByUserid(1);
        //Assert
        assertEquals(1,result.size());
    }
}