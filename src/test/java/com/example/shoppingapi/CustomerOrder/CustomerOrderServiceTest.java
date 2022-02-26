package com.example.shoppingapi.CustomerOrder;

import com.example.shoppingapi.model.CustomerOrder;
import com.example.shoppingapi.model.CustomerOrderItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerOrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private CustomerOrderItemRepository customerOrderItemRepository;

    @Test
    void findCustomerOrderbyUser() {


    }

    @Test
    void findCustomerOrderbyOrderId() {
    }

    @Test
    void confirmOrder() {
    }
}