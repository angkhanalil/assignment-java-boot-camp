package com.example.shoppingapi.Cart;

import com.example.shoppingapi.model.Cart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CartRepositoryTest {

    @Autowired
    private CartRepository cartRepository;

    @BeforeEach
    void setup(){
        Cart cart = new Cart();
        cart.setCartid(1);
        cart.setItemid(1);
        cart.setItemqty(1);
        cart.setUserid(1);
        cartRepository.save(cart);
    }

    @Test
    void findByUserid_with_success() {
        List<Cart> result = cartRepository.findByUserid(1);
        //Assert
        assertTrue(!result.isEmpty());

    }

    @Test
    void findByUserid_with_failed() {
        List<Cart> result = cartRepository.findByUserid(2);
        //Assert
        assertTrue(result.isEmpty());

    }
}